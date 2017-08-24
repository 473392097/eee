package com.lanou.action;

import com.lanou.bean.CrmClasses;
import com.lanou.bean.CrmCourseType;
import com.lanou.service.CourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by lanouhn on 17/8/22.
 */
@Scope(value = "prototype")
public class CourseAction extends ActionSupport {

    private CrmCourseType crmCourseType;
    private CourseService courseService;


    //查询所有
    public String  findAll(){
      List<CrmCourseType> crmCourseTypess = courseService.findAll();
        System.out.println(crmCourseTypess.get(0).getCourseName());
        ActionContext.getContext().put("findAll",crmCourseTypess);
        return "findAll";
    }

    //测试
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


    //高级查询  git测试用的
    //测试用的   最近加的
    public String superSelect(){

        System.out.println("课程开始时间"+crmCourseType.getTotalStart());
        System.out.println("课程结束时间"+crmCourseType.getTotalEnd());
        System.out.println("最低费用"+crmCourseType.getCostStart());
        System.out.println("最高费用"+crmCourseType.getCostEnd());


        System.out.println("课程名称是"+crmCourseType.getCourseName());
        System.out.println("课程名称是"+crmCourseType.getRemark());
        List<CrmCourseType> crmCourseTypess = courseService.superSelect(crmCourseType.getCourseName(),crmCourseType.getRemark(),crmCourseType.getTotalStart(),crmCourseType.getTotalEnd(),crmCourseType.getCostStart(),crmCourseType.getCostEnd());
        ActionContext.getContext().put("findAll",crmCourseTypess);
        return "superSelect";
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
