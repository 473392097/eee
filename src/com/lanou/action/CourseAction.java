package com.lanou.action;

import com.lanou.bean.CrmClasses;
import com.lanou.bean.CrmCourseType;
import com.lanou.service.CourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanouhn on 17/8/22.
 */
public class CourseAction extends ActionSupport {
    @Autowired
    private CrmCourseType crmCourseType;
    private CourseService courseService;


    //查询所有
    public String  findAll(){
      List<CrmCourseType> crmCourseType = courseService.findAll();
        System.out.println(crmCourseType.get(0).getCourseName());
        ActionContext.getContext().put("crmCourseType",crmCourseType);
        return "findAll";
    }

    public String preEdit(){

        System.out.println("id"+ crmCourseType.getCourseTypeId());
        System.out.println("编辑");
        System.out.println("id"+ crmCourseType.getCourseTypeId());
        CrmCourseType crmCourseTypes = courseService.findByid(crmCourseType.getCourseTypeId());
        ActionContext.getContext().put("crmCourseTypes",crmCourseTypes);
        System.out.println("编辑后");
        return "preEdit";
    }


    //编辑

    public String update(){
        System.out.println("更新"+crmCourseType.getCourseName());
        courseService.update(crmCourseType);
        return "update";
    }




    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public CrmCourseType getCrmCourseType() {
        return crmCourseType;
    }

    public void setCrmCourseType(CrmCourseType crmCourseType) {
        this.crmCourseType = crmCourseType;
    }
}
