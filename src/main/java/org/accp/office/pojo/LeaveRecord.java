package org.accp.office.pojo;/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author: bianj
 * Email: vipbooks@qq.com
 * Version: 6.0.0
 */
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 请假记录表\r\n(LEAVERECORD)
 * 
 * @author bianj
 * @version 1.0.0 2019-06-10
 */
public class LeaveRecord {

    /** 请假记录id */
    private Integer leaveId;

    /** 开始时间 */
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /** 结束时间 */
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /** 请假天数 */
    private Integer leaveDays;

    /** 请假事由 */
    private String reason;

    /** 请假人(外键员工id) */
    private Integer leaveBy;

    /** 待处理人(外键员工id) */
    private Integer disposeBy;

    /** 请假审批状态(外键审批状态id) */
    private Integer approvalStateId;

    private Employee leaveEmp;//请假人

    private Employee disposeEmp;//处理人

    private ApprovalState approvalState;//审批状态

    private List<ReviewRecord> reviewRecords;//审核记录集合

    public LeaveRecord() {
    }

    public LeaveRecord(Integer leaveId, Date startDate, Date endDate, Integer leaveDays, String reason, Integer leaveBy, Integer disposeBy, Integer approvalStateId, Employee leaveEmp, Employee disposeEmp, ApprovalState approvalState, List<ReviewRecord> reviewRecords) {
        this.leaveId = leaveId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveDays = leaveDays;
        this.reason = reason;
        this.leaveBy = leaveBy;
        this.disposeBy = disposeBy;
        this.approvalStateId = approvalStateId;
        this.leaveEmp = leaveEmp;
        this.disposeEmp = disposeEmp;
        this.approvalState = approvalState;
        this.reviewRecords = reviewRecords;
    }

    @Override
    public String toString() {
        return "LeaveRecord{" +
                "leaveId=" + leaveId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", leaveDays=" + leaveDays +
                ", reason='" + reason + '\'' +
                ", leaveBy=" + leaveBy +
                ", disposeBy=" + disposeBy +
                ", approvalStateId=" + approvalStateId +
                ", leaveEmp=" + leaveEmp +
                ", disposeEmp=" + disposeEmp +
                ", approvalState=" + approvalState +
                ", reviewRecords=" + reviewRecords +
                '}';
    }

    public List<ReviewRecord> getReviewRecords() {
        return reviewRecords;
    }

    public void setReviewRecords(List<ReviewRecord> reviewRecords) {
        this.reviewRecords = reviewRecords;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getLeaveBy() {
        return leaveBy;
    }

    public void setLeaveBy(Integer leaveBy) {
        this.leaveBy = leaveBy;
    }

    public Integer getDisposeBy() {
        return disposeBy;
    }

    public void setDisposeBy(Integer disposeBy) {
        this.disposeBy = disposeBy;
    }

    public Integer getApprovalStateId() {
        return approvalStateId;
    }

    public void setApprovalStateId(Integer approvalStateId) {
        this.approvalStateId = approvalStateId;
    }

    public Employee getLeaveEmp() {
        return leaveEmp;
    }

    public void setLeaveEmp(Employee leaveEmp) {
        this.leaveEmp = leaveEmp;
    }

    public Employee getDisposeEmp() {
        return disposeEmp;
    }

    public void setDisposeEmp(Employee disposeEmp) {
        this.disposeEmp = disposeEmp;
    }

    public ApprovalState getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(ApprovalState approvalState) {
        this.approvalState = approvalState;
    }
}