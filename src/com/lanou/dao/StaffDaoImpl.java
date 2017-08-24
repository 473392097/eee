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

    @Override
    public String update(CrmStaff crmStaff) {
        System.out.println("我是dao层");
        this.getHibernateTemplate().update(crmStaff);
        System.out.println("我是dao2层");
        return null;
    }

    @Override
    public void save(CrmStaff crmStaff) {
        System.out.println("我是dao层");
        this.getHibernateTemplate().save(crmStaff);
    }

    public List<CrmDepartment> findDepart(){
        String hql="from CrmDepartment";
        List<CrmDepartment> crmDepartmentList = (List<CrmDepartment>) this.getHibernateTemplate().find(hql);
        return crmDepartmentList;

    }


    public List<CrmPost> findAll(int depId) {
        String hql = "from CrmPost where department.id = ?";
        return (List<CrmPost>) this.getHibernateTemplate().find(hql,depId);
    }


    //高级查询
    public List<CrmStaff> limitSelect(String staffName,String postName,String depName){
       String str = "";
       if(depName!=null && !depName.equals("")){
            str+=" s.post.department.depId =:dn and";
       }
        if(postName!=null && !postName.equals("")){
            str+=" s.post.postId =:pn and";
        }
        if(staffName!=null && !staffName.equals("")){
            str+=" s.staffName =:sn";
        }

        StringBuilder sb;
        if(str!=null && !str.equals("")){
            sb=new StringBuilder(str);
            sb.insert(0," where ");
            str=sb.toString();
        }

        String hql = "from CrmStaff as s "+str;
        if(hql.endsWith("and")){
             hql=hql.substring(0,hql.length()-3);
        }
        System.out.println("拼接的sql为:"+hql);
        Session session =factory.getCurrentSession();
        System.out.println(session);
        System.out.println(hql);
        System.out.println(staffName);
        Query query =session.createQuery(hql);

        if(staffName!=null && !staffName.equals("")){
            query.setParameter("sn",staffName);
        }if(postName!=null && !postName.equals("")){
            query.setParameter("pn",postName);
        }if(depName!=null && !depName.equals("")){
            query.setParameter("dn",depName);
        }
        List<CrmStaff> crmStaffs = query.list();
        return crmStaffs;
    }


    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }


}
