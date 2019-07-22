package org.accp.office.dao;

import java.util.List;
import org.accp.office.pojo.ReviewRecord;
import org.accp.office.pojo.ReviewRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRecordMapper {
    long countByExample(ReviewRecordExample example);

    int deleteByExample(ReviewRecordExample example);

    int insert(ReviewRecord record);

    int insertSelective(ReviewRecord record);

    List<ReviewRecord> selectByExample(ReviewRecordExample example);

    int updateByExampleSelective(@Param("record") ReviewRecord record, @Param("example") ReviewRecordExample example);

    int updateByExample(@Param("record") ReviewRecord record, @Param("example") ReviewRecordExample example);

    List<ReviewRecord> selectByOrderId(Integer orderId);//查询单个报销/请假记录表 审查的所有记录
}