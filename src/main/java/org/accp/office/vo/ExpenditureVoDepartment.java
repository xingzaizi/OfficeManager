package org.accp.office.vo;

import org.accp.office.pojo.Department;

/**
 * @author XingYu Yi
 * @create 2019-06-21 14:04
 * 公司报销统计Vo
 */
public class ExpenditureVoDepartment {
    private double totalMoney;//总计

    private int year;//年份

    private int month;//月份

    private Department department;//部门

    public ExpenditureVoDepartment() {
    }

    public ExpenditureVoDepartment(double totalMoney, int year, int month, Department department) {
        this.totalMoney = totalMoney;
        this.year = year;
        this.month = month;
        this.department = department;
    }

    @Override
    public String toString() {
        return "ExpenditureVoDepartment{" +
                "totalMoney=" + totalMoney +
                ", year=" + year +
                ", month=" + month +
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
