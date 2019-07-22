package org.accp.office.vo;

import org.accp.office.pojo.Department;

/**
 * @author XingYu Yi
 * @create 2019-06-21 14:04
 * 部门报销统计Vo
 */
public class ExpenditureVoEmployee {
    private double totalMoney;//报销总额

    private int year;//年份

    private int month;//月份

    private String empName;//报销人名称

    private Department department;//部门

    public ExpenditureVoEmployee() {
    }

    public ExpenditureVoEmployee(double totalMoney, int year, int month, String empName, Department department) {
        this.totalMoney = totalMoney;
        this.year = year;
        this.month = month;
        this.empName = empName;
        this.department = department;
    }

    @Override
    public String toString() {
        return "ExpenditureVoEmployee{" +
                "totalMoney=" + totalMoney +
                ", year=" + year +
                ", month=" + month +
                ", empName='" + empName + '\'' +
                ", department=" + department +
                '}';
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
