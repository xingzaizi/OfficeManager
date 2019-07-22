package org.accp.office.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.accp.office.dao.EmployeeMapper;
import org.accp.office.dao.LeaveRecordMapper;
import org.accp.office.dao.ReviewRecordMapper;
import org.accp.office.pojo.*;
import org.accp.office.util.OrderUtil;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author XingYu Yi
 * @create 2019-06-11 8:18
 * 请假信息Service
 */
@Service
public class LeaveRecordBiz {
    @Autowired
    LeaveRecordMapper leaveRecordMapper;
    @Autowired
    ReviewRecordMapper reviewRecordMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 分页查询所有请假记录表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<LeaveRecord> pageLeave(Integer pageNum, Integer pageSize, Employee emp,Integer stateId){
        LeaveRecordExample leaveRecordExample = new LeaveRecordExample();
        PageHelper.startPage(pageNum,pageSize);

        //判断当前登录的用户是什么角色 不同的角色可以查看不同范围人的请假记录
        Integer depId = emp.getDepId();//部门id
        Integer posId = emp.getPositionId();//职位id
        LeaveRecordExample.Criteria criteria = leaveRecordExample.createCriteria();
        if (stateId!=-1){
            criteria.andApprovalStateIdEqualTo(stateId);
        }
        if(posId==3||posId==4){
            //如果是人事经理或者总经理则查询全部的请假记录
            criteria.andApprovalStateIdNotEqualTo(1);
            return new PageInfo<LeaveRecord>(leaveRecordMapper.selectByExample(leaveRecordExample));
        }else if(posId==2){
            //如果是研发经理则查询自己以及本部门的请假记录
            return new PageInfo<LeaveRecord>(leaveRecordMapper.selectByDepId(depId,emp.getEmployeeId()));
        }else{
            //如果是总经理、财务、出纳、普通员工则查询自己的请假记录
            criteria.andLeaveByEqualTo(emp.getEmployeeId());
            return new PageInfo<LeaveRecord>(leaveRecordMapper.selectByExample(leaveRecordExample));
        }
    }
    /**
     * 根据职位查询到符合这个职位的一群员工
     * 将其中一个员工的id返回出去
     * @param positionId
     * @return
     */
    public Integer getDisposeBy(Integer positionId){
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andPositionIdEqualTo(positionId);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        return employees.get(0).getEmployeeId();
    }

    /**
     * 修改请假记录状态
     * 提交请假
     * @param leaveRecord 里面只需要有主键id和状态id
     * @return
     */
    public boolean updateLeaveState(LeaveRecord leaveRecord){
        LeaveRecord leave = leaveRecordMapper.selectByPrimaryKey(leaveRecord.getLeaveId());
        Integer pId = leave.getLeaveEmp().getPositionId();

        //如果当前请假员工的职位id==1  ==》  是普通员工请假
        if(pId==1){
            //则下个处理人为部门经理
            leaveRecord.setDisposeBy(getDisposeBy(2));
        }else if(pId==2){
            //或者当前请假员工的职位id==2  ==》  是部门经理请假
            //则下个处理人为总经理
            leaveRecord.setDisposeBy(getDisposeBy(4));
        }
        LeaveRecordExample leaveRecordExample = new LeaveRecordExample();
        if (leaveRecordMapper.updateByPrimaryKeySelective(leaveRecord)<=0){
            throw new RuntimeException("存档失败");
        }
        return true;
    }

    /**
     * 保存审查记录
     * @param reviewRecord
     * @return
     */
    public boolean saveReviewRecord(ReviewRecord reviewRecord){
        reviewRecord.setReviewDate(new Date());
        if (reviewRecordMapper.insert(reviewRecord)<=0){
            throw new RuntimeException("审查失败");
        }
        LeaveRecord leave = leaveRecordMapper.selectByPrimaryKey(Integer.parseInt(reviewRecord.getOrderId()));
        Employee leaveEmp = leave.getDisposeEmp();//处理人
        //通过或者拒绝 都将状态修改为已审批
        leave.setApprovalStateId(4);

        //修改请假记录状态
        if (reviewRecord.getReviewStateId()==1){
            //如果通过

            //如果原来下个处理人的职位是部门经理或者总经理 则转给人事处理
            if (leaveEmp.getPositionId() == 2||leaveEmp.getPositionId() == 4) {
                leave.setDisposeBy(getDisposeBy(3));//将人事的id放入下个处理人
            }else if(leaveEmp.getPositionId() == 3){
                //如果原来下个处理人的职位是人事 则流程结束
                leave.setDisposeBy(null);
            }
        }else if(reviewRecord.getReviewStateId()==3){
            //如果拒绝 则下个处理人=null
            leave.setDisposeBy(null);
        }
        if (leaveRecordMapper.updateByPrimaryKey(leave)<=0){
            throw new RuntimeException("审查失败");
        }
        return true;
    }

    /**
     * 提交请假信息
     * @param leaveRecord
     * @return
     */
    public boolean saveLeaveRecord(LeaveRecord leaveRecord){
        leaveRecord.setApprovalStateId(1);
        if (leaveRecordMapper.insert(leaveRecord)<=0){
            throw new RuntimeException("提交成功");
        }
        return true;
    }

    /**
     * 查询单个请假信息
     * @param leaveId
     * @return
     */
    public LeaveRecord getLeaveRecord(Integer leaveId){
        return leaveRecordMapper.selectByPrimaryKey(leaveId);
    }
}
