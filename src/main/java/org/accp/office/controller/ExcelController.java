package org.accp.office.controller;

import cn.hutool.core.convert.Convert;
import org.accp.office.biz.ChartBiz;
import org.accp.office.util.ViewExcel;
import org.accp.office.vo.ExpenditureVoDepartment;
import org.accp.office.vo.ExpenditureVoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XingYu Yi
 * @create 2019-06-22 12:56
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    ChartBiz chartBiz;
    @RequestMapping("saveEmp")
    @ResponseBody
    public ModelAndView saveExcel(Integer year, Integer month, Integer depId, String fangfa, String where, ModelMap modelmap) throws IOException {
        try {
            List<Map<String, Object>> mapList=new ArrayList<Map<String, Object>>();
            String[] titles=null;
            if (fangfa.equals("selectAllDepByMonth")){
                List<ExpenditureVoDepartment> expenditureVoDepartments = chartBiz.selectAllDepByMonth(null, year, month, month);

                if (where.equals("byMonth")){
                    Integer index=0;
                    String[] title={"编号","报销总额","年份","月份","部门"};
                    titles=title;
                    for (ExpenditureVoDepartment voDep : expenditureVoDepartments) {
                        index++;
                        Map<String, Object> map=new HashMap<String, Object>();
                        map.put("编号", index.toString());
                        map.put("报销总额", Convert.toStr(voDep.getTotalMoney()));
                        map.put("年份", Convert.toStr(voDep.getYear()));
                        map.put("月份", Convert.toStr(voDep.getMonth()));
                        map.put("部门", voDep.getDepartment().getDepartmentName());
                        mapList.add(map);
                    }
                }else if(where.equals("byYear")){
                    Integer index=0;
                    String[] title={"编号","部门名称","报销总额","年份"};
                    titles=title;
                    for (ExpenditureVoDepartment voDep : expenditureVoDepartments) {
                        index++;
                        Map<String, Object> map=new HashMap<String, Object>();
                        map.put("编号", index.toString());
                        map.put("部门名称", voDep.getDepartment().getDepartmentName());
                        map.put("报销总额", Convert.toStr(voDep.getTotalMoney()));
                        map.put("年份", Convert.toStr(voDep.getYear()));
                        mapList.add(map);
                    }
                }

            }else if(fangfa.equals("selectAllDepByYear")){
                List<ExpenditureVoDepartment> expenditureVoDepartments = chartBiz.selectAllDepByYear(null, year, year);
                if (where.equals("byMonth")){
                    Integer index=0;
                    String[] title={"编号","报销总额","年份","月份","部门"};
                    titles=title;
                    for (ExpenditureVoDepartment voDep : expenditureVoDepartments) {
                        index++;
                        Map<String, Object> map=new HashMap<String, Object>();
                        map.put("编号", index.toString());
                        map.put("报销总额", Convert.toStr(voDep.getTotalMoney()));
                        map.put("年份", Convert.toStr(voDep.getYear()));
                        map.put("月份", Convert.toStr(voDep.getMonth()));
                        map.put("部门", voDep.getDepartment().getDepartmentName());
                        mapList.add(map);
                    }
                }else if(where.equals("byYear")){
                    Integer index=0;
                    String[] title={"编号","部门名称","报销总额","年份"};
                    titles=title;
                    for (ExpenditureVoDepartment voDep : expenditureVoDepartments) {
                        index++;
                        Map<String, Object> map=new HashMap<String, Object>();
                        map.put("编号", index.toString());
                        map.put("部门名称", voDep.getDepartment().getDepartmentName());
                        map.put("报销总额", Convert.toStr(voDep.getTotalMoney()));
                        map.put("年份", Convert.toStr(voDep.getYear()));
                        mapList.add(map);
                    }
                }
            }else if(fangfa.equals("listExpenditureVoEmployee")){

                List<ExpenditureVoEmployee> expenditureVoEmployees = chartBiz.listExpenditureVoEmployee(depId, year, month);
                if (where.equals("byMonth")){
                    Integer index=0;
                    String[] title={"编号","报销人","报销总额","年份","月份","部门"};
                    titles=title;
                    for (ExpenditureVoEmployee voEmp : expenditureVoEmployees) {
                        index++;
                        Map<String, Object> map=new HashMap<String, Object>();
                        map.put("编号", index.toString());
                        map.put("报销人", voEmp.getEmpName());
                        map.put("报销总额", Convert.toStr(voEmp.getTotalMoney()));
                        map.put("年份", Convert.toStr(voEmp.getYear()));
                        map.put("月份", Convert.toStr(voEmp.getMonth()));
                        map.put("部门", voEmp.getDepartment().getDepartmentName());
                        mapList.add(map);
                    }
                }else if(where.equals("byYear")){
                    Integer index=0;
                    String[] title ={"编号","报销人","报销总额","年份"};
                    titles=title;
                    for (ExpenditureVoEmployee voEmp : expenditureVoEmployees) {
                        index++;
                        Map<String, Object> map=new HashMap<String, Object>();
                        map.put("编号", index.toString());
                        map.put("报销人", voEmp.getEmpName());
                        map.put("报销总额", Convert.toStr(voEmp.getTotalMoney()));
                        map.put("年份", Convert.toStr(voEmp.getYear()));
                        mapList.add(map);
                    }
                }
            }

            ViewExcel excel=new ViewExcel(titles);
            modelmap.put("excelList", mapList);
            return new ModelAndView(excel,modelmap);
        }catch (Exception e){
            return null;
        }
    }
}
