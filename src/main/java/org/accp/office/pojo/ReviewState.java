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
/**
 * 审查状态表\r\n(REVIEWSTATE)
 * 
 * @author bianj
 * @version 1.0.0 2019-06-10
 */
public class ReviewState {
    /** 版本号 */
    private static final long serialVersionUID = -3670286544597359369L;

    /* This code was generated by TableGo tools, mark 1 begin. */

    /** 审查状态id */
    private Integer reviewStateId;

    /** 审查结果 */
    private String reviewStateResult;

    /* This code was generated by TableGo tools, mark 1 end. */

    /* This code was generated by TableGo tools, mark 2 begin. */

    public ReviewState() {
    }

    public ReviewState(Integer reviewStateId, String reviewStateResult) {
        this.reviewStateId = reviewStateId;
        this.reviewStateResult = reviewStateResult;
    }

    @Override
    public String toString() {
        return "ReviewState{" +
                "reviewStateId=" + reviewStateId +
                ", reviewStateResult='" + reviewStateResult + '\'' +
                '}';
    }

    /**
     * 获取审查状态id
     * 
     * @return 审查状态id
     */
    public Integer getReviewStateId() {
        return this.reviewStateId;
    }

    /**
     * 设置审查状态id
     * 
     * @param reviewStateId
     *          审查状态id
     */
    public void setReviewStateId(Integer reviewStateId) {
        this.reviewStateId = reviewStateId;
    }

    /**
     * 获取审查结果
     * 
     * @return 审查结果
     */
    public String getReviewStateResult() {
        return this.reviewStateResult;
    }

    /**
     * 设置审查结果
     * 
     * @param reviewStateResult
     *          审查结果
     */
    public void setReviewStateResult(String reviewStateResult) {
        this.reviewStateResult = reviewStateResult;
    }

    /* This code was generated by TableGo tools, mark 2 end. */
}