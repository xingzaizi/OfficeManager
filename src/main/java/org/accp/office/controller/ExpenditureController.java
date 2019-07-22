package org.accp.office.controller;

import com.github.pagehelper.PageInfo;
import org.accp.office.biz.ExpenditureBiz;
import org.accp.office.pojo.*;
import org.accp.office.util.Msg;
import org.accp.office.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.ejb.PostActivate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ChenSK
 * 报销单
 * @date 2019-06-11 - 10:24
 */
@Controller
public class ExpenditureController {

    @Autowired
    ExpenditureBiz expenditureBiz;


    @RequestMapping("/findExpenditure")
    @ResponseBody
    public PageInfo<Expenditure> findExpenditure(int page, HttpSession session,Integer stateId) {
        Employee employee = (Employee) session.getAttribute("emp");
        PageInfo<Expenditure> expenditure = expenditureBiz.findExpenditure(employee, page,stateId);
        return expenditure;
    }

    @RequestMapping("/getExpenditureInfo/{id}/{cz}")
    public String getExpenditureInfo(@PathVariable String id, @PathVariable String cz, Model model) {
        Expenditure expenditureInfo = expenditureBiz.getExpenditureInfo(id);
        model.addAttribute("data", expenditureInfo);
        if(cz.equals("sp")){
            model.addAttribute("cz",cz);
        }
        return "expenditureInfo";
    }

    @RequestMapping("/addExpenditure")
    @ResponseBody
    public Msg addExpenditure(@RequestBody Expenditure expenditure, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("emp");
        System.out.println(expenditure);
        expenditure.setCreateBy(emp.getEmployeeId());//报销人id
        expenditure.setCreateDate(new Date());//创建时间
        if(expenditureBiz.addExpenditure(expenditure,emp) >0 ){
            return Msg.succeed();
        }
        return Msg.failed();
    }

    @RequestMapping("/addExamination")
    @ResponseBody
    public Msg addExamination(@RequestBody ReviewRecord reviewRecord, HttpSession session){
        Employee emp = (Employee) session.getAttribute("emp");
        reviewRecord.setReviewDate(new Date());//报销时间
        reviewRecord.setEmpId(emp.getEmployeeId());
        System.out.println(reviewRecord);
        if( expenditureBiz.addExamineRecord(reviewRecord) >0){
            return Msg.succeed();
        }
        return Msg.failed();
    }

    @RequestMapping("/delExpenditure")
    @ResponseBody
    public Msg delExpenditure(String id){
        if(expenditureBiz.delExpenditure(id) > 0){
            return Msg.succeed();
        }
        return Msg.failed();
    }

    @RequestMapping("/submit")
    @ResponseBody
    public Msg submit(String id,Float moni,HttpSession session){
        Employee emp = (Employee) session.getAttribute("emp");
        if( expenditureBiz.submit(id,moni>=5000,emp) >0){
            return Msg.succeed();
        }
        return Msg.failed();
    }

    @RequestMapping("/ex/{id}")
    public String getExpenditure(@PathVariable String id, Model model) {
        Expenditure expenditure = expenditureBiz.getExpenditureInfo(id);
        model.addAttribute("data",expenditure);
        return "updExpenditure";
    }

    @RequestMapping("/delDetail")
    @ResponseBody
    public Msg delDetail(Integer id, Float money, String order){
        if(expenditureBiz.delDetail(id,money,order) > 0){
            return Msg.succeed();
        }
        return Msg.failed();
    }

    @RequestMapping("/addDetail")
    @ResponseBody
    public Msg addDetail(String comment,Float money,String orderId,String proveImage){
        ExpenditureDetail expenditureDetail = new ExpenditureDetail();
        expenditureDetail.setComment(comment);
        expenditureDetail.setMoney(money);
        expenditureDetail.setProveImage(proveImage);
        expenditureDetail.setExpenditureId(orderId);

        if(expenditureBiz.addDetail(expenditureDetail)>0){
            return Msg.succeed();
        }
        return Msg.failed();
    }

    @RequestMapping("/updExpenditure")
    @ResponseBody
    public Msg updExpenditure(String orderId, String reason,Integer status){
        Expenditure expenditure = new Expenditure();
        expenditure.setReason(reason);
        if(status!=-1){
            expenditure.setApprovalStateId(status);
        }
        if(expenditureBiz.updExpenditureStatus(orderId,expenditure)>0){
            return Msg.succeed();
        }
        return Msg.failed();
    }

    @RequestMapping("/fielUpload")
    @ResponseBody
    public Msg fielUpload(HttpServletRequest req){
        String tpName = "";

        try {
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
            MultipartFile file = mreq.getFile("file");
            String realPath = req.getSession().getServletContext().getRealPath("\\static\\");
            tpName= OrderUtil.getOrderIdByTime()+".jpg";
            file.transferTo(new File(realPath+"\\"+tpName));
        }catch (Exception e){
            return Msg.custom(500,"图片上传失败");
        }

        return Msg.custom(200,tpName);
    }


}
