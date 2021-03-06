package com.lanou.action;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.CrmDepartment;
import com.lanou.bean.CrmPost;
import com.lanou.bean.CrmStaff;

import com.lanou.service.StaffServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by lanouhn on 17/8/16.
 */

public class FirstAction extends ActionSupport{

    private StaffServiceImpl staffService;
    private CrmDepartment crmDepartment;
    private CrmStaff crmStaff;
    private CrmPost crmPost;

    //登录
    public String staffLogin(){
        CrmStaff crmStaff1 = staffService.login(crmStaff);
        if(crmStaff1 != null){
            Map<String, Object> map =  ActionContext.getContext().getSession();
            map.put("session", crmStaff1);
            return  SUCCESS;
        }
        // 添加错误信息 -- 字段错误 我们显示所有的错误信息
        this.addFieldError("crmStaff.loginName", "用户名或密码错误");
        return LOGIN;
    }



    //查询所有
     public  String findAll(){
       List<CrmStaff> allStaff = staffService.findAllStaff();
       System.out.println( "部门id是"+allStaff.get(0).getPost().getDepartment().getDepName());
       ActionContext.getContext().put("allStaff",allStaff);
       System.out.println("到这里了");
        return "findAll";
     }

     //基本数据回显
     public String preEdit() throws IOException {
         System.out.println(crmStaff);
         CrmStaff findStaff = staffService.findByid(crmStaff.getStaffId());
         System.out.print("编辑:"+findStaff);
//         List<CrmDepartment>  crmDepartmentList = staffService.findDepart();
//         ActionContext.getContext().put("crmDepartmentList",crmDepartmentList);
//          HttpServletResponse response=ServletActionContext.getResponse();
//          response.setContentType("text/html;charset=utf-8");
//          response.getWriter().write(JSON.toJSONString(crmDepartmentList));
//         System.out.println(JSON.toJSONString(crmDepartmentList));
         ActionContext.getContext().put("findStaff",findStaff);
         return "preEdit";
     }

     //部门和职务回显
     public String findDepart() throws IOException {
         List<CrmDepartment>  crmDepartmentList = staffService.findDepart();
         System.out.println(JSON.toJSONString(crmDepartmentList));
         HttpServletResponse response=ServletActionContext.getResponse();
         response.setContentType("text/html;charset=utf-8");
         //将数据传入到前端
         response.getWriter().write(JSON.toJSONString(crmDepartmentList));
         return NONE;
     }

     //编辑功能
     public String update(){
         System.out.println();
         System.out.println("需要更新的staff为:"+crmStaff);
         staffService.update(crmStaff);
         System.out.println("到这里了");
         System.out.println(staffService.update(crmStaff));
         return  "updatesuccess";
     }

     //添加保存
     public String save(){
         System.out.println(crmStaff.toString());
         System.out.println("id为"+crmStaff.getStaffId());
         System.out.println("添加");
         staffService.save(crmStaff);
         System.out.println("再添加");
         return "tianjia";
     }

     //条件查询(高级查询)
    public String limitSelect(){
        System.out.println("进入actionl");
        System.out.println(crmStaff);
        List<CrmStaff> crmStaffs = staffService.limitSelct(crmStaff.getStaffName(),crmStaff.getPost().getPostId(),crmStaff.getPost().getDepartment().getDepId());
        System.out.println("高级查询的结果:"+crmStaffs);
        System.out.println("到这了");
        ActionContext.getContext().put("allStaff",crmStaffs);
         return "findAll";
    }


    //get/set方法
    public StaffServiceImpl getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffServiceImpl staffService) {
        this.staffService = staffService;
    }

    public CrmStaff getCrmStaff() {
        return crmStaff;
    }

    public void setCrmStaff(CrmStaff crmStaff) {
        this.crmStaff = crmStaff;
    }

    public CrmDepartment getCrmDepartment() {
        return crmDepartment;
    }

    public void setCrmDepartment(CrmDepartment crmDepartment) {
        this.crmDepartment = crmDepartment;
    }

    public CrmPost getCrmPost() {
        return crmPost;
    }

    public void setCrmPost(CrmPost crmPost) {
        this.crmPost = crmPost;
    }


}
