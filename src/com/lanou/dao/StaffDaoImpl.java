package com.lanou.dao;

import com.lanou.bean.CrmDepartment;
import com.lanou.bean.CrmPost;
import com.lanou.bean.CrmStaff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanouhn on 17/8/16.
 */

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao{

    @Autowired
    private SessionFactory factory;

    //员工登录
    public CrmStaff find(String loginName,String loginPwd) {
        System.out.println("我是dao层");
        String hql = "from CrmStaff where loginName=? and loginPwd=?";
        List<CrmStaff> allStaff= (List<CrmStaff>) this.getHibernateTemplate().find(hql,loginName,loginPwd);
//        Session session=factory.openSession();
//        Query query=session.createQuery(hql);
//        query.setParameter(0,loginName);
//        query.setParameter(1,loginPwd);
//        List<CrmStaff> allStaff=query.list();
        if(allStaff.size()==0){
             return  null;
        }
        return allStaff.get(0);
    }


    //员工管理
    @Override
    public List<CrmStaff> findAll() {
        String hql = "from CrmStaff";
        List<CrmStaff> lists = (List<CrmStaff>) this.getHibernateTemplate().find(hql);
        return lists;
    }

    //通过id查询
    public CrmStaff findByid(String staffId) {

        return  this.getHibernateTemplate().get(CrmStaff.class,staffId);
    }

    public List<CrmDepartment> findDepart(){
        String hql="from CrmDepartment";
        List<CrmDepartment> crmDepartmentList = (List<CrmDepartment>) this.getHibernateTemplate().find(hql);
        return crmDepartmentList;

    };


    public List<CrmPost> findAll(int depId) {
        String hql = "from CrmPost where department.id = ?";
        return (List<CrmPost>) this.getHibernateTemplate().find(hql,depId);
    }






    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }


}
