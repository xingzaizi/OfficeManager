package org.accp.office.biz;

import org.accp.office.dao.EmployeeMapper;
import org.accp.office.pojo.Employee;
import org.accp.office.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XingYu Yi
 * @create 2019-06-11 8:16
 * 员工Service
 */
@Service
public class EmployeeBiz {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 登录验证
     * @param employee
     * @return
     */
    public Employee getEmployeeByUserNameAndPwd(Employee employee){
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmployeeNameEqualTo(employee.getEmployeeName()).andPasswordEqualTo(employee.getPassword());
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if (employees==null||employees.size()==0){
            throw new RuntimeException("用户名或密码错误请重新登录");
        }
        return employees.get(0);
    }

    /**
     * 注册员工
     * @param employee
     * @return
     */
    public boolean saveEmployee(Employee employee){
        if (employeeMapper.insertSelective(employee)<=0){
            throw new RuntimeException("注册失败");
        }
        return true;
    }
}
