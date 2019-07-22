package org.accp.office.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.accp.office.dao.ChartMapper;
import org.accp.office.vo.ExpenditureVoDepartment;
import org.accp.office.vo.ExpenditureVoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XingYu Yi
 * @create 2019-06-21 18:30
 */
@Service
public class ChartBiz {
    @Autowired
    ChartMapper chartMapper;

    /**
     * 查询单个部门
     * @param depId
     * @param year
     * @return
     */
    public List<ExpenditureVoEmployee> listExpenditureVoEmployee(Integer depId,Integer year,Integer month){
        //如果是总经理则查询全部 分组by部门
        if (depId==4) {
            depId=null;
        }
        return chartMapper.listExpenditureVoEmployee(depId, year, month, month);
    }

    /**
     * 查询部门
     * @param depId
     * @param year
     * @param startMonth
     * @param endMonth
     * @return
     */
    public PageInfo<ExpenditureVoDepartment> listExpenditureVoDepartment(Integer depId,Integer year,Integer startMonth,Integer endMonth,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        //如果是总经理则查询全部
        if (depId==4) {
            depId=null;
        }
        return new PageInfo<ExpenditureVoDepartment>(chartMapper.listExpenditureVoDepartment(depId, year, startMonth, endMonth));
    }

    /**
     * 查询年度
     * @param depId
     * @param startYear
     * @param endYear
     * @return
     */
    public List<ExpenditureVoDepartment> listExpenditureVoDepartmentByYear(Integer depId,Integer startYear,Integer endYear){
        //如果是总经理则查询全部
        if (depId==4) {
            depId=null;
        }
        return chartMapper.listExpenditureVoDepartmentByYear(depId, startYear, endYear);
    }

    //总经理查询详细部门月度报销
    public List<ExpenditureVoDepartment> selectAllDepByYear(Integer depId,Integer startYear,Integer endYear){
        return chartMapper.selectAllDepByYear(depId, startYear, endYear);
    }

    //总经理查询详细部门年度报销
    public List<ExpenditureVoDepartment> selectAllDepByMonth(Integer depId,Integer year,Integer startMonth,Integer endMonth){
        return chartMapper.selectAllDepByMonth(depId,year,startMonth,endMonth);
    }
}
