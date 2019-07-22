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

import java.util.Date;
import java.util.List;

/**
 * 报销信息表\r\n(EXPENDITURE)
 * 
 * @author bianj
 * @version 1.0.0 2019-06-10
 */
public class Expenditure {

    /** 报销单号 */
    private String expenditureId;

    /** 总金额 */
    private Float totalMoney;

    /** 填报时间 */
    @JSONField(format = "yyyy-MM-dd")
    private Date createDate;

    /** 填写人(外键员工id) */
    private Integer createBy;

    /** 待处理人(外键员工id) */
    private Integer disposeBy;

    /** 报销状态(外键审批状态id) */
    private Integer approvalStateId;

    /** 报销事由*/
    private String reason;

    private Employee createEmp;//填写人

    private Employee disposeEmp;//处理人

    private ApprovalState approvalState;//审批状态

    private List<ReviewRecord> reviewRecords;//审查集合

    private List<ExpenditureDetail> expenditureDetails;//报销详细信息集合
    public Expenditure() {
    }

    public Expenditure(String expenditureId, Float totalMoney, Date createDate, Integer createBy, Integer disposeBy, Integer approvalStateId, Employee createEmp, Employee disposeEmp, ApprovalState approvalState) {
        this.expenditureId = expenditureId;
        this.totalMoney = totalMoney;
        this.createDate = createDate;
        this.createBy = createBy;
        this.disposeBy = disposeBy;
        this.approvalStateId = approvalStateId;
        this.createEmp = createEmp;
        this.disposeEmp = disposeEmp;
        this.approvalState = approvalState;
    }

    @Override
    public String toString() {
        return "Expenditure{" +
                "expenditureId='" + expenditureId + '\'' +
                ", totalMoney=" + totalMoney +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", disposeBy=" + disposeBy +
                ", approvalStateId=" + approvalStateId +
                ", createEmp=" + createEmp +
                ", disposeEmp=" + disposeEmp +
                ", approvalState=" + approvalState +
                '}';
    }



    public List<ExpenditureDetail> getExpenditureDetails() {
        return expenditureDetails;
    }

    public void setExpenditureDetails(List<ExpenditureDetail> expenditureDetails) {
        this.expenditureDetails = expenditureDetails;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ReviewRecord> getReviewRecords() {
        return reviewRecords;
    }

    public void setReviewRecords(List<ReviewRecord> reviewRecords) {
        this.reviewRecords = reviewRecords;
    }

    public String getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(String expenditureId) {
        this.expenditureId = expenditureId;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
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

    public Employee getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(Employee createEmp) {
        this.createEmp = createEmp;
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