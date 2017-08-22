package com.lanou.bean;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanouhn on 17/8/16.
 */
@Component
public class CrmCourseType {
    private String courseTypeId;  	//课程类别Id
    private Double courseCost;		//费用
    private Integer total;			//总学时
    private String courseName;		//课程类别名称
    private String remark;	        //描述


    //课程类别和班级关系:一个课程类别可以有多个班级。
    private Set<CrmClasses> classesSet = new HashSet<CrmClasses>();

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<CrmClasses> getClassesSet() {
        return classesSet;
    }

    public void setClassesSet(Set<CrmClasses> classesSet) {
        this.classesSet = classesSet;
    }
}
