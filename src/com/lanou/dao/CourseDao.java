package com.lanou.dao;


import com.lanou.bean.CrmClasses;
import com.lanou.bean.CrmCourseType;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by lanouhn on 17/8/22.
 */
public class CourseDao extends HibernateDaoSupport {

       public List<CrmCourseType> findAll(){
           System.out.println("进入action");
           String  hql= "from CrmCourseType";
           return (List<CrmCourseType>) this.getHibernateTemplate().find(hql);
       }




    public CrmCourseType findByid(String courseTypeId) {

        System.out.println("我是dao层");
        System.out.println("查询语句");
        return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);

    }




    public void update(CrmCourseType crmCourseType){
           this.getHibernateTemplate().update(crmCourseType);
       }
}
