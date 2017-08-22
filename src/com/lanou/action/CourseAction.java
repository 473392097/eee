package com.lanou.action;

import com.lanou.bean.CrmClasses;
import com.lanou.service.CourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanouhn on 17/8/22.
 */
public class CourseAction extends ActionSupport {
    private CrmClasses crmClasses;
    private CourseService courseService;


    //查询所有
    public String  findAll(){
      List<CrmClasses> crmClasses = courseService.findAll();
        System.out.println("名字是"+crmClasses.get(0).getName());
        System.out.println("费用是"+crmClasses.get(0).getCourseType().getCourseCost());

        ActionContext.getContext().put("crmClasses",crmClasses);
        return "findAll";
    }

    public String preEdit(){
       CrmClasses getClass = courseService.findByid(crmClasses.getClassId());
        ActionContext.getContext().put("getClass",getClass);
        return "preEdit";
    }


    //编辑

    public String update(){
        System.out.println("要保存的数据是"+crmClasses.getCourseType().getCourseName());
        courseService.update(crmClasses);
        return "update";
    }




    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public CrmClasses getCrmClasses() {
        return crmClasses;
    }

    public void setCrmClasses(CrmClasses crmClasses) {
        this.crmClasses = crmClasses;
    }
}
