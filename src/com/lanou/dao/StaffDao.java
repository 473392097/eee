package com.lanou.dao;

import com.lanou.bean.CrmDepartment;
import com.lanou.bean.CrmPost;
import com.lanou.bean.CrmStaff;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/**
 * Created by lanouhn on 17/8/16.
 */
public interface StaffDao{
     CrmStaff find(String loginName,String loginPwd);
     public List<CrmStaff> findAll();
     //通过id查询  基本信息回显
     public CrmStaff findByid(String staffId);
     //部门和职务回显
     public String update(CrmStaff crmStaff);
     public void save(CrmStaff crmStaff);


}
