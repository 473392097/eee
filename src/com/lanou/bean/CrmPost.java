package com.lanou.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanouhn on 17/8/16.
 */
public class CrmPost {
    private String postId;	 //职务编号
    private String postName;	 //职务名称

    // 职务和部门的关系： 多对一 ，多个职务同属于一个部门
    @JSONField(serialize=false)
    private CrmDepartment department;

    // 职务和员工的关系：一对多，一个职务可以有多个员工
    @JSONField(serialize=false)
    private Set<CrmStaff> staffSet = new HashSet<CrmStaff>();


    //set和get 方法
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public CrmDepartment getDepartment() {
        return department;
    }

    public void setDepartment(CrmDepartment department) {
        this.department = department;
    }

    public Set<CrmStaff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<CrmStaff> staffSet) {
        this.staffSet = staffSet;
    }

    @Override
    public String toString() {
        return "CrmPost{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }
}
