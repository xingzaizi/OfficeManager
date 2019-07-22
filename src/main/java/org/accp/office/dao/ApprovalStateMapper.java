package org.accp.office.dao;

import java.util.List;
import org.accp.office.pojo.ApprovalState;
import org.accp.office.pojo.ApprovalStateExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalStateMapper {
    long countByExample(ApprovalStateExample example);

    int deleteByExample(ApprovalStateExample example);

    int deleteByPrimaryKey(Integer approvalStateId);

    int insert(ApprovalState record);

    int insertSelective(ApprovalState record);

    List<ApprovalState> selectByExample(ApprovalStateExample example);

    ApprovalState selectByPrimaryKey(Integer approvalStateId);

    int updateByExampleSelective(@Param("record") ApprovalState record, @Param("example") ApprovalStateExample example);

    int updateByExample(@Param("record") ApprovalState record, @Param("example") ApprovalStateExample example);

    int updateByPrimaryKeySelective(ApprovalState record);

    int updateByPrimaryKey(ApprovalState record);
}