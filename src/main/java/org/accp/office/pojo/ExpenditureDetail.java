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
 * 报销详细信息表\r\n(EXPENDITUREDETAIL)
 *
 * @author bianj
 * @version 1.0.0 2019-06-10
 */
public class ExpenditureDetail {

    /** 报销详细id */
    private Integer expenditureDetailId;

    /** 项目说明 */
    private String comment;

    /** 项目金额 */
    private Float money;

    /** 凭据截图 */
    private String proveImage;

    /** 报销单号(外键报销信息id) */
    private String expenditureId;

    private Expenditure expenditure;//报销主表

    public ExpenditureDetail() {
    }

    public ExpenditureDetail(Integer expenditureDetailId, String comment, Float money, String proveImage, String expenditureId, Expenditure expenditure) {
        this.expenditureDetailId = expenditureDetailId;
        this.comment = comment;
        this.money = money;
        this.proveImage = proveImage;
        this.expenditureId = expenditureId;
        this.expenditure = expenditure;
    }

    public ExpenditureDetail(String comment, Float money) {
        this.comment = comment;
        this.money = money;
    }

    @Override
    public String toString() {
        return "ExpenditureDetail{" +
                "expenditureDetailId=" + expenditureDetailId +
                ", comment='" + comment + '\'' +
                ", money=" + money +
                ", proveImage='" + proveImage + '\'' +
                ", expenditureId=" + expenditureId +
                ", expenditure=" + expenditure +
                '}';
    }

    public Integer getExpenditureDetailId() {
        return expenditureDetailId;
    }

    public void setExpenditureDetailId(Integer expenditureDetailId) {
        this.expenditureDetailId = expenditureDetailId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getProveImage() {
        return proveImage;
    }

    public void setProveImage(String proveImage) {
        this.proveImage = proveImage;
    }

    public String getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(String expenditureId) {
        this.expenditureId = expenditureId;
    }

    public Expenditure getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(Expenditure expenditure) {
        this.expenditure = expenditure;
    }
}