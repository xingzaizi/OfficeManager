package org.accp.office.dao;

import java.util.List;

import org.accp.office.pojo.LeaveRecord;
import org.accp.office.pojo.LeaveRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRecordMapper {
    long countByExample(LeaveRecordExample example);

    int deleteByExample(LeaveRecordExample example);

    int deleteByPrimaryKey(Integer leaveId);

    int insert(LeaveRecord record);

    int insertSelective(LeaveRecord record);

    List<LeaveRecord> selectByExample(LeaveRecordExample example);

    LeaveRecord selectByPrimaryKey(Integer leaveId);

    int updateByExampleSelective(@Param("record") LeaveRecord record, @Param("example") LeaveRecordExample example);

    int updateByExample(@Param("record") LeaveRecord record, @Param("example") LeaveRecordExample example);

    int updateByPrimaryKeySelective(LeaveRecord record);

    int updateByPrimaryKey(LeaveRecord record);

    List<LeaveRecord> selectByDepId(@Param("depId") Integer depId,@Param("leaveEmpId") Integer leaveEmpId);//查询单个部门的所有请假信息
}