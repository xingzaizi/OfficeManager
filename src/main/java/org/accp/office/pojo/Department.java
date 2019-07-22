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

import javafx.geometry.Pos;

import java.util.List;

/**
 * 部门信息表\r\n(DEPARTMENT)
 * 
 * @author bianj
 * @version 1.0.0 2019-06-10
 */
public class Department {

    /** 部门编号 */
    private Integer departmentId;

    /** 部门名称 */
    private String departmentName;

    private List<Employee> employees;//单个部门的所有员工

    private List<Position> positions;//单个部门下所有的职位

    public Department() {
    }

    public Department(Integer departmentId, String departmentName, List<Employee> employees, List<Position> positions) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employees = employees;
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                ", positions=" + positions +
                '}';
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}