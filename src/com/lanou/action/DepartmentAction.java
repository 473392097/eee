package com.lanou.action;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lanou.bean.CrmDepartment;
import com.lanou.bean.CrmPost;
import com.lanou.bean.CrmStaff;
import com.lanou.service.DepartServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lanouhn on 17/8/18.
 */
public class DepartmentAction extends ActionSupport{
    private DepartServiceImpl departService;

    public String findDepart() throws IOException {
        Gson gson = new Gson();
        List<CrmDepartment>  crmDepartmentList = departService.findDepart();
        ActionContext.getContext().put("crmDepartmentList",crmDepartmentList);
        HttpServletResponse response= ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
//        装换成json数据
        String Jsonlist = gson.toJson(crmDepartmentList);

        response.getWriter().write(JSON.toJSONString(crmDepartmentList));

        System.out.println(JSON.toJSONString(crmDepartmentList));
        return SUCCESS;
    }



    public DepartServiceImpl getDepartService() {
        return departService;
    }

    public void setDepartService(DepartServiceImpl departService) {
        this.departService = departService;
    }
}
