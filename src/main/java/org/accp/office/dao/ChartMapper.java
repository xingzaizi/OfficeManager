package org.accp.office.dao;


import org.accp.office.vo.ExpenditureVoDepartment;
import org.accp.office.vo.ExpenditureVoEmployee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XingYu Yi
 * @create 2019-06-21 15:41
 */
@Repository
public interface ChartMapper {

    List<ExpenditureVoDepartment> listExpenditureVoDepartment(@Param("depId") Integer depId, @Param("year") Integer year, @Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth);//查询整个公司的部门报销情况

    List<ExpenditureVoEmployee> listExpenditureVoEmployee(@Param("depId") Integer depId, @Param("year") Integer year, @Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth);//查询整个部门的员工报销情况

    List<ExpenditureVoDepartment> listExpenditureVoDepartmentByYear(@Param("depId") Integer depId,@Param("startYear")Integer startYear,@Param("endYear")Integer endYear);//分组年份查询部门报销情况 如果总经理则查询全部

    List<ExpenditureVoDepartment> selectAllDepByYear(@Param("depId") Integer depId,@Param("startYear")Integer startYear,@Param("endYear")Integer endYear);//查询所有部门的年度报销

    List<ExpenditureVoDepartment> selectAllDepByMonth(@Param("depId") Integer depId, @Param("year") Integer year, @Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth);//查询所有部门的年度报销


}
