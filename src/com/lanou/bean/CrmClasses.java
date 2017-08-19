package com.lanou.bean;

import java.util.Date;

/**
 * Created by lanouhn on 17/8/16.
 */
public class CrmClasses {
    private String classId;	           //所属课程Id
    private String name;		            //课程名称
    private Date beginTime;	            //开班时间
    private Date endTime;	            //毕业时间
    private String status;	             //状态
    private Integer totalCount;		//总人数

    //班级和课程类别关系：多个班级可属于一个课程类别
    private CrmCourseType courseType;


    //set和get方法

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public CrmCourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CrmCourseType courseType) {
        this.courseType = courseType;
    }
}
