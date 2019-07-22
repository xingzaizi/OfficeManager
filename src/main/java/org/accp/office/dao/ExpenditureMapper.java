package org.accp.office.dao;

import java.util.List;
import org.accp.office.pojo.Expenditure;
import org.accp.office.pojo.ExpenditureExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureMapper {
    long countByExample(ExpenditureExample example);

    int deleteByExample(ExpenditureExample example);

    int insert(Expenditure record);

    int insertSelective(Expenditure record);

    List<Expenditure> selectByExample(ExpenditureExample example);

    int updateByExampleSelective(@Param("record") Expenditure record, @Param("example") ExpenditureExample example);

    int updateByExample(@Param("record") Expenditure record, @Param("example") ExpenditureExample example);

    Expenditure getExpenditureByExpenditureId(String expenditureId);
}