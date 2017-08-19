package com.lanou.dao;

import com.lanou.bean.CrmDepartment;
import com.lanou.bean.CrmPost;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by lanouhn on 17/8/18.
 */
public class DepartDaoImpl  extends HibernateDaoSupport {
    public List<CrmDepartment> findDepart(){
        String hql="from CrmDepartment";
        List<CrmDepartment> crmDepartmentList = (List<CrmDepartment>) this.getHibernateTemplate().find(hql);
        return crmDepartmentList;
    }





}
