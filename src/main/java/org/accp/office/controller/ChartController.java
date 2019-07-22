package org.accp.office.controller;

import com.github.pagehelper.PageInfo;
import org.accp.office.biz.ChartBiz;
import org.accp.office.pojo.Employee;
import org.accp.office.vo.ExpenditureVoDepartment;
import org.accp.office.vo.ExpenditureVoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author XingYu Yi
 * @create 2019-06-21 18:32
 */
@Controller
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    ChartBiz chartBiz;

    /**
     * 根据年份 月份 查询部门
     * @param model
     * @param year
     * @param startMonth
     * @param endMonth
     * @param month
     * @param pageNum
     * @param pageSize
     * @param session
     * @return
     */
    @RequestMapping("dep")
    @ResponseBody
    public PageInfo<ExpenditureVoDepartment> listChartVoDep(Model model, Integer year,Integer startMonth, Integer endMonth, Integer month,@RequestParam(required = false,defaultValue = "1")Integer pageNum, @RequestParam(required = false,defaultValue = "10")Integer pageSize, HttpSession session){
        Employee emp = (Employee) session.getAttribute("emp");
        return chartBiz.listExpenditureVoDepartment(emp.getDepId(),year,startMonth,endMonth,pageNum,pageSize);
    }

    /**
     * 根据年份查询部门
     * @param model
     * @param year
     * @param startYear
     * @param endYear
     * @param session
     * @return
     */
    @RequestMapping("dep/year")
    public String listChartVoDepByYear(Model model,Integer year,Integer startYear,Integer endYear, HttpSession session){
        Employee emp = (Employee) session.getAttribute("emp");
        model.addAttribute("voDep",chartBiz.listExpenditureVoDepartmentByYear(emp.getDepId(),startYear,endYear));
        return "chartbyyear";
    }

    /**
     * 查询详细  查询部门内部信息
     * @param model
     * @param year
     * @param month
     * @param session
     * @return
     */
    @RequestMapping("emp")
    public String listChartVoEmp(Model model, Integer year, Integer month, HttpSession session,String where){
        Employee emp = (Employee) session.getAttribute("emp");
        Integer depId = emp.getDepId();
        if (depId==4){
            //如果是总经理查看详细
            if (month!=null){
                model.addAttribute("exVoEmp",chartBiz.selectAllDepByMonth(null,year,month,month));
                model.addAttribute("where",where);
                model.addAttribute("fangfa","selectAllDepByMonth");
                return "chartbydep";
            }
            model.addAttribute("exVoEmp",chartBiz.selectAllDepByYear(null,year,year));
            model.addAttribute("where",where);
            model.addAttribute("fangfa","selectAllDepByYear");
            return "chartbydep";
        }else{
            model.addAttribute("exVoEmp",chartBiz.listExpenditureVoEmployee(emp.getDepId(),year,month));
            model.addAttribute("where",where);
            model.addAttribute("fangfa","listExpenditureVoEmployee");
            return "chartbyemp";
        }

    }
}
