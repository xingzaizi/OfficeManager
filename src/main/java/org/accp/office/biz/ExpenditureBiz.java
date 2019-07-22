package org.accp.office.biz;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.accp.office.dao.EmployeeMapper;
import org.accp.office.dao.ExpenditureDetailMapper;
import org.accp.office.dao.ExpenditureMapper;
import org.accp.office.dao.ReviewRecordMapper;
import org.accp.office.pojo.*;
import org.accp.office.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XingYu Yi
 * @create 2019-06-11 8:18
 * 报销信息Service
 */
@Service
public class ExpenditureBiz {
    @Autowired
    ExpenditureMapper expenditureMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    ExpenditureDetailMapper expenditureDetailMapper;

    @Autowired
    ReviewRecordMapper reviewRecordMapper;


    /**
     * 查询报表
     *
     * @return
     */
    public PageInfo<Expenditure> findExpenditure(Employee emp, int page,Integer stateId) {
        //职位
        int positions = emp.getPositionId();
        //部门
        int department = emp.getDepId();
        PageHelper.startPage(page, 6);
        //创建查询条件对象
        ExpenditureExample expenditureExample = new ExpenditureExample();
        ExpenditureExample.Criteria criteria = expenditureExample.createCriteria();
        if (positions == 1 || positions == 3) {
            criteria.andCreateByEqualTo(emp.getEmployeeId());//查看自己的报销单 和自己部门的所有yuangong
        } else if (positions == 2) {//
            expenditureExample.or().andCreateByEqualTo(emp.getEmployeeId());//查看自己的
            expenditureExample.or().andCreateByIn(findEmployeId(department, 1)).andApprovalStateIdNotEqualTo(1);//或者同一个部门职位比自己低的
        } else if (positions == 4 || positions == 5 || positions == 6) {//总经理  财务  出纳
            //查看所有
            expenditureExample.createCriteria().andApprovalStateIdNotEqualTo(1);
        }
        if (stateId!=-1){
            criteria.andApprovalStateIdEqualTo(stateId);
        }
        List<Expenditure> expenditures = expenditureMapper.selectByExample(expenditureExample);

        return new PageInfo<Expenditure>(expenditures);
    }

    public List<Integer> findEmployeId(int bm, int zw) {
        List<Integer> ids = new ArrayList<>();
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andDepIdEqualTo(bm).andPositionIdEqualTo(zw);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        for (Employee employee : employees) {
            ids.add(employee.getEmployeeId());
        }
        return ids;
    }

    /**
     * 根据报销单号查询报销单信息
     *
     * @param id
     * @return
     */
    public Expenditure getExpenditureInfo(String id) {
        ExpenditureExample expenditureExample = new ExpenditureExample();
        expenditureExample.createCriteria().andExpenditureIdEqualTo(id);
        return expenditureMapper.selectByExample(expenditureExample).get(0);
    }

    public int addExpenditure(Expenditure expenditure, Employee employee) {
        try {
            String exid = OrderUtil.getOrderIdByTime();//报销单编号
            expenditure.setExpenditureId(exid);
            if (expenditure.getApprovalStateId() == 2) {//待审批
                //下一个审批人
                expenditure.setDisposeBy(findApprover(employee.getDepId(), employee.getPositionId(), expenditure.getTotalMoney() >= 5000, exid));
            }else{
                expenditure.setDisposeBy(0);
            }
            expenditureMapper.insert(expenditure);//添加报销单
            //添加报销单详细
            for (ExpenditureDetail expenditureDetail : expenditure.getExpenditureDetails()) {
                expenditureDetail.setExpenditureId(exid);
                expenditureDetailMapper.insert(expenditureDetail);
            }
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    /**
     * 找出下一个审批人
     *
     * @param bm   创建人的部门id
     * @param zw   创建人的职位id
     * @param flag 是否经过总经理
     * @param exid 报销单id
     * @return
     */
    public int findApprover(Integer bm, Integer zw, boolean flag, String exid) {
        List<Integer> flows = new ArrayList<>();//审批经过的流程

        int employeeId = findEmployeeId(bm, zw + 1);//找出自己的职位id+1也就是自己部门的部门经理,如果找不出则判断是否找部门经理
        if (employeeId != -1) {//找到
            flows.add(employeeId);
        }
        if (flag) {//是否经过总经理的审批
            flows.add(findEmployeeId(4, 4));
        }

        flows.add(findEmployeeId(3, 5));//找财务

        for (Integer flow : flows) {
            ReviewRecordExample reviewRecordExample = new ReviewRecordExample();
            reviewRecordExample.createCriteria().andEmpIdEqualTo(flow).andOrderIdEqualTo(exid);//判断这个审批人是否审批过此报销单()
            List<ReviewRecord> reviewRecords = reviewRecordMapper.selectByExample(reviewRecordExample);
            if (reviewRecords.size() == 0) {
                return flow;
            } else {//审批人审批过此报销单
                //判断审批人是否为已打回
                ReviewRecord reviewRecord = reviewRecords.stream().max((p1, p2) -> Convert.toInt(p1.getReviewId()) - Convert.toInt(p2.getReviewId())).get();//返回最新的一次审批记录
                if (reviewRecord.getReviewStateId() == 2) {//已打回
                    return flow;
                }
            }
        }

        return findEmployeeId(3, 6);//出纳
    }

    /**
     * 根据员工的部门和职位查询出员工的id如果查询不出则放回-1
     *
     * @param bm
     * @param zw
     * @return
     */
    public int findEmployeeId(int bm, int zw) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andDepIdEqualTo(bm).andPositionIdEqualTo(zw);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if (employees.size() > 0) {
            return employees.get(0).getEmployeeId();
        }
        return -1;
    }

    /**
     * 审批
     *
     * @return
     */
    public int addExamineRecord(ReviewRecord reviewRecord) {
        try {
            ExpenditureExample ex = new ExpenditureExample();
            ex.createCriteria().andExpenditureIdEqualTo(reviewRecord.getOrderId());
            List<Expenditure> expenditures = expenditureMapper.selectByExample(ex);
            Employee employee = employeeMapper.selectByPrimaryKey(expenditures.get(0).getCreateBy());

            reviewRecordMapper.insert(reviewRecord);//添加审批记录
            Expenditure expenditureInfo = getExpenditureInfo(reviewRecord.getOrderId());
            Expenditure expenditure = new Expenditure();

            int status = -1;
            if (reviewRecord.getEmpId() == 6) {//如果审批人
                status = 5;//已付款
                expenditure.setDisposeBy(0);//清空审批人
            } else {
                int nextId = findApprover(employee.getDepId(), employee.getPositionId(), expenditureInfo.getTotalMoney() >= 5000, reviewRecord.getOrderId());//下一个审批人
                expenditure.setDisposeBy(nextId);
                //修改报销单状态
                if (reviewRecord.getReviewStateId() == 1) {
                    //通过
                    status = 3;
                } else if (reviewRecord.getReviewStateId() == 2) {
                    //打回
                    status = 6;
                } else if (reviewRecord.getReviewStateId() == 3) {
                    //拒绝
                    status = 9;
                    expenditure.setDisposeBy(0);//清空审批人
                }
            }

            expenditure.setApprovalStateId(status);
            updExpenditureStatus(reviewRecord.getOrderId(), expenditure);//修改报销单状态和审批人
        } catch (Exception e) {
            throw new RuntimeException("审批异常");
        }
        return 1;
    }

    /**
     * 根据订单编号修改订单
     *
     * @param order
     * @return
     */
    public int updExpenditureStatus(String order, Expenditure expenditure) {
        try {
            ExpenditureExample expenditureExample = new ExpenditureExample();
            expenditureExample.createCriteria().andExpenditureIdEqualTo(order);
            expenditureMapper.updateByExampleSelective(expenditure, expenditureExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 删除报销单
     * @param id
     * @return
     */
    public int delExpenditure(String id){
        ExpenditureExample expenditureExample = new ExpenditureExample();
        expenditureExample.createCriteria().andExpenditureIdEqualTo(id);
        return expenditureMapper.deleteByExample(expenditureExample);
    }

    /**
     * 提交报销单
     * @param orderId
     * @return
     */
    public int submit(String orderId,boolean flag,Employee employee){
        try {
            Expenditure expenditure = new Expenditure();
            expenditure.setApprovalStateId(2);//待审批
            expenditure.setDisposeBy(findApprover(employee.getDepId(),employee.getPositionId(),flag,orderId));
            updExpenditureStatus(orderId,expenditure);
        }catch (Exception e){
            return -1;
        }
        return 1;
    }

    /**
     * 删除详细
     * @param id
     * @return
     */
    public int delDetail(Integer id,Float money,String order){
        try {
            expenditureDetailMapper.deleteByPrimaryKey(id);
            updJg(order,money,false);
        }catch (Exception e){
            return -1;
        }
        return 1;
    }

    public int addDetail(ExpenditureDetail expenditureDetail){
        try {
            expenditureDetailMapper.insert(expenditureDetail);
            updJg(expenditureDetail.getExpenditureId(),expenditureDetail.getMoney(),true);//修改报销单的价格
        }catch (Exception e){
            return -1;
        }
        return 1;
    }

    public int updJg(String orderId,Float money,boolean flag){
        Expenditure expenditureInfo = getExpenditureInfo(orderId);
        Expenditure expenditure = new Expenditure();
        if(flag){
            expenditure.setTotalMoney( expenditureInfo.getTotalMoney()+money );
        }else {
            expenditure.setTotalMoney( expenditureInfo.getTotalMoney()-money );
        }

        return updExpenditureStatus(orderId,expenditure);
    }
}
