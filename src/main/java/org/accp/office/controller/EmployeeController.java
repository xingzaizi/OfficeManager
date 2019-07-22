package org.accp.office.controller;

import org.accp.office.biz.EmployeeBiz;
import org.accp.office.pojo.Employee;
import org.accp.office.util.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * @author XingYu Yi
 * @create 2019-06-11 8:22
 */
@SessionAttributes(value = {"emp"})
@Controller
public class EmployeeController {
    @Autowired
    EmployeeBiz employeeBiz;
    @RequestMapping("/log_in")
    public String login(Model model, Employee employee){
        try {
            //调用Service层方法
            Employee emp = employeeBiz.getEmployeeByUserNameAndPwd(employee);
            model.addAttribute("emp",emp);
            model.addAttribute("msg", MsgUtil.custom(200, "登录成功","index"));
        } catch (Exception e) {
            model.addAttribute("msg",MsgUtil.custom(500, e.getMessage()));
        }
        return "msg";
    }
    
    @RequestMapping("/back")
    public String back(Model model, HttpSession session, SessionStatus sessionStatus){
        try {
            //调用Service层方法
            sessionStatus.setComplete();
            model.addAttribute("msg",MsgUtil.custom(200, "退出成功","index"));
        } catch (Exception e) {
            model.addAttribute("msg",MsgUtil.custom(500, e.getMessage()));
        }
        return "msg";
    }
}
