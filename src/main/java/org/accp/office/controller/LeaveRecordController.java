package org.accp.office.controller;

import com.github.pagehelper.MSUtils;
import com.github.pagehelper.PageInfo;
import org.accp.office.biz.LeaveRecordBiz;
import org.accp.office.pojo.Employee;
import org.accp.office.pojo.LeaveRecord;
import org.accp.office.pojo.ReviewRecord;
import org.accp.office.util.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author XingYu Yi
 * @create 2019-06-11 10:13
 */
@Controller
public class LeaveRecordController {
    @Autowired
    LeaveRecordBiz leaveRecordBiz;

    /**
     * 分页查询请假信息
     * @param model
     * @param pageNum
     * @param pageSize
     * @param session
     * @return
     */
    @RequestMapping("/pageLeave")
    public @ResponseBody PageInfo<LeaveRecord> pageLeave(Model model, @RequestParam(required = false,defaultValue = "1")Integer pageNum, @RequestParam(required = false,defaultValue = "10")Integer pageSize, HttpSession session,Integer stateId){
        Employee emp = (Employee) session.getAttribute("emp");
        return leaveRecordBiz.pageLeave(pageNum,pageSize,emp,stateId);
    }

    /**
     * 修改请假状态
     * @param model
     * @param leaveRecord
     * @return
     */
    @PutMapping("/leaves/leave")
    @ResponseBody
    public MsgUtil updateLeaveState(Model model,@RequestBody LeaveRecord leaveRecord){
        try {
            //调用Service层方法
            leaveRecordBiz.updateLeaveState(leaveRecord);
            return MsgUtil.custom(200, "修改成功");
        } catch (Exception e) {
            return MsgUtil.custom(500, e.getMessage());
        }
    }

    /**
     * 保存请假信息
     * @param model
     * @param leaveRecord
     * @param session
     * @return
     */
    @RequestMapping("/leaves/leave")
    public String saveLeaveRecord(Model model,LeaveRecord leaveRecord,HttpSession session){
        try {
            //调用Service层方法
            Employee emp = (Employee) session.getAttribute("emp");
            leaveRecord.setLeaveBy(emp.getEmployeeId());
            leaveRecordBiz.saveLeaveRecord(leaveRecord);
            model.addAttribute("msg",MsgUtil.custom(200, "保存成功","leave"));
        } catch (Exception e) {
            model.addAttribute("msg",MsgUtil.custom(500, e.getMessage()));
        }
        return "msg";
    }

    /**
     * Get请求 获取单个请假信息并进行编辑
     * @param model
     * @param operate 0为查看 1为编辑
     * @return
     */
    @GetMapping("/leaves/leave/{leaveId}/{operate}")
    public String getLeaveRecord(Model model,@PathVariable Integer leaveId,@PathVariable Integer operate){
        model.addAttribute("audit",operate);
        model.addAttribute("leaveRecord",leaveRecordBiz.getLeaveRecord(leaveId));
        return "auditleave";
    }
    
    @RequestMapping("/saveReviewRecord")
    @ResponseBody
    public MsgUtil saveReviewRecord(Model model, @RequestBody ReviewRecord reviewRecord, HttpSession session){
        try {
            //调用Service层方法
            Employee emp = (Employee) session.getAttribute("emp");
            reviewRecord.setEmpId(emp.getEmployeeId());
            leaveRecordBiz.saveReviewRecord(reviewRecord);
            return MsgUtil.custom(200, "审批成功", "leave");
        } catch (Exception e) {
            return MsgUtil.custom(500, e.getMessage());
        }
    }
}