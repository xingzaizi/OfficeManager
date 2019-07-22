package org.accp.office.dao;

import java.util.List;
import org.accp.office.pojo.ReviewState;
import org.accp.office.pojo.ReviewStateExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewStateMapper {
    long countByExample(ReviewStateExample example);

    int deleteByExample(ReviewStateExample example);

    int deleteByPrimaryKey(Integer reviewStateId);

    int insert(ReviewState record);

    int insertSelective(ReviewState record);

    List<ReviewState> selectByExample(ReviewStateExample example);

    ReviewState selectByPrimaryKey(Integer reviewStateId);

    int updateByExampleSelective(@Param("record") ReviewState record, @Param("example") ReviewStateExample example);

    int updateByExample(@Param("record") ReviewState record, @Param("example") ReviewStateExample example);

    int updateByPrimaryKeySelective(ReviewState record);

    int updateByPrimaryKey(ReviewState record);
}