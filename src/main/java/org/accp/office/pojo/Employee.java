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
 * 员工信息表\r\n(EMPLOYEE)
 * 
 * @author bianj
 * @version 1.0.0 2019-06-10
 */
public class Employee {


    /** 员工编号 */
    private Integer employeeId;

    /** 员工姓名 */
    private String employeeName;

    /** 密码 */
    private String password;

    /** 联系方式 */
    private String contact;

    /** 邮箱 */
    private String email;

    /** 所属部门(外键部门id) */
    private Integer depId;

    /** 所在职位(外键职位id) */
    private Integer positionId;

    private Department department;//所在部门

    private Position position;//所在职位

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String password, String contact, String email, Integer depId, Integer positionId, Department department, Position position) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.password = password;
        this.contact = contact;
        this.email = email;
        this.depId = depId;
        this.positionId = positionId;
        this.department = department;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", password='" + password + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", depId=" + depId +
                ", positionId=" + positionId +
                ", department=" + department +
                ", position=" + position +
                '}';
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}