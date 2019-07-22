package org.accp.office.dao;

import java.util.List;
import org.accp.office.pojo.ExpenditureDetail;
import org.accp.office.pojo.ExpenditureDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureDetailMapper {
    long countByExample(ExpenditureDetailExample example);

    int deleteByExample(ExpenditureDetailExample example);

    int deleteByPrimaryKey(Integer expenditureDetailId);

    int insert(ExpenditureDetail record);

    int insertSelective(ExpenditureDetail record);

    List<ExpenditureDetail> selectByExample(ExpenditureDetailExample example);

    ExpenditureDetail selectByPrimaryKey(Integer expenditureDetailId);

    int updateByExampleSelective(@Param("record") ExpenditureDetail record, @Param("example") ExpenditureDetailExample example);

    int updateByExample(@Param("record") ExpenditureDetail record, @Param("example") ExpenditureDetailExample example);

    int updateByPrimaryKeySelective(ExpenditureDetail record);

    int updateByPrimaryKey(ExpenditureDetail record);

    List<ExpenditureDetail> selectByExpenditureId(Integer expenditureId);
}