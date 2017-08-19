package com.lanou.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanouhn on 17/8/16.
 */
public class CrmDepartment {

    private String depId;	//部门编号
    private String depName;	 //部门名称

    //部门和职务关系：一对多 ， 一个部门对应多个职务
    private Set<CrmPost> postSet = new HashSet<CrmPost>();

    // 省略setter、getter方法
    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<CrmPost> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<CrmPost> postSet) {
        this.postSet = postSet;
    }

    @Override
    public String toString() {
        return "CrmDepartment{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                ", postSet=" + postSet +
                '}';
    }
}
