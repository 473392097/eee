package com.lanou.bean;

import java.util.Date;

/**
 * Created by lanouhn on 17/8/16.
 */
public class CrmStaff {
    private  String staffId; 	//员工Id
    private String loginName;	//登录名
    private String loginPwd;	//登录密码
    private String staffName;	//员工姓名
    private String gender;	//性别
    private Date onDutyDate;	//入职日期

    //员工和职务关系：多对一，多个员工属于同一个职务
    private CrmPost post;

    // 省略setter、getter方法


    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    public CrmPost getPost() {
        return post;
    }

    public void setPost(CrmPost post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "CrmStaff{" +
                "staffId='" + staffId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate=" + onDutyDate +
                ", post=" + post +
                '}';
    }
}
