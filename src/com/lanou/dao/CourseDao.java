package com.lanou.dao;


import com.lanou.bean.CrmClasses;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by lanouhn on 17/8/22.
 */
public class CourseDao extends HibernateDaoSupport {
       public List<CrmClasses> findAll(){
           String  hql= "from CrmClasses ";

           return (List<CrmClasses>) this.getHibernateTemplate().find(hql);
       }

    public CrmClasses findByid(String classId) {

        return  this.getHibernateTemplate().get(CrmClasses.class,classId);
    }




    public void update(CrmClasses crmClasses){
           this.getHibernateTemplate().update(crmClasses);
       }
}
