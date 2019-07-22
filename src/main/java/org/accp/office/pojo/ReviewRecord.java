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

/**
 * 审查记录表\r\n(REVIEWRECORD)
 * 
 * @author bianj
 * @version 1.0.0 2019-06-10
 */
public class ReviewRecord {

    /** 审查记录id */
    private Integer reviewId;

    /** 审查时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date reviewDate;

    /** 审查意见 */
    private String reviewIdea;

    /** 报销/请假id(外键) */
    private String orderId;

    /** 处理人(外键员工id) */
    private Integer empId;

    /** 审查状态(外键审查状态id) */
    private Integer reviewStateId;

    private Employee employee;//处理人

    private ReviewState reviewState;//审查状态对象

    public ReviewRecord() {
    }

    public ReviewRecord(Integer reviewId, Date reviewDate, String reviewIdea, String orderId, Integer empId, Integer reviewStateId, Employee employee, ReviewState reviewState) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.reviewIdea = reviewIdea;
        this.orderId = orderId;
        this.empId = empId;
        this.reviewStateId = reviewStateId;
        this.employee = employee;
        this.reviewState = reviewState;
    }

    @Override
    public String toString() {
        return "ReviewRecord{" +
                "reviewId='" + reviewId + '\'' +
                ", reviewDate=" + reviewDate +
                ", reviewIdea='" + reviewIdea + '\'' +
                ", orderId=" + orderId +
                ", empId=" + empId +
                ", reviewStateId=" + reviewStateId +
                ", employee=" + employee +
                ", reviewState=" + reviewState +
                '}';
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewIdea() {
        return reviewIdea;
    }

    public void setReviewIdea(String reviewIdea) {
        this.reviewIdea = reviewIdea;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getReviewStateId() {
        return reviewStateId;
    }

    public void setReviewStateId(Integer reviewStateId) {
        this.reviewStateId = reviewStateId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ReviewState getReviewState() {
        return reviewState;
    }

    public void setReviewState(ReviewState reviewState) {
        this.reviewState = reviewState;
    }
}