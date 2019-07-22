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
 * 职位信息表\r\n(POSITION)
 * 
 * @author bianj
 * @version 1.0.0 2019-06-10
 */
public class Position {
    /** 职位编号 */
    private Integer positionId;

    /** 职位名称 */
    private String positionName;

    /** 部门编号(外键部门id) */
    private Integer depId;

    private Department department;//部门对象

    public Position() {
    }

    public Position(Integer positionId, String positionName, Integer depId, Department department) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.depId = depId;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", depId=" + depId +
                ", department=" + department +
                '}';
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}