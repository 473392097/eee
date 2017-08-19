package com.lanou.service;

import com.lanou.bean.CrmDepartment;
import com.lanou.bean.CrmPost;
import com.lanou.bean.CrmStaff;

import java.util.List;

/**
 * Created by lanouhn on 17/8/16.
 */
public interface StaffService {


    //员工登录
    public CrmStaff login(CrmStaff crmStaff);
    public List<CrmStaff> findAllStaff();
    public CrmStaff findByid(String staffId);
    public List<CrmDepartment> findDepart();
    public String update(CrmStaff crmStaff);

}
