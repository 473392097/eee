package com.lanou.dao;


import com.lanou.bean.CrmClasses;
import com.lanou.bean.CrmCourseType;
import com.lanou.bean.CrmStaff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by lanouhn on 17/8/22.
 */
@Scope(value = "prototype")
public class CourseDao extends HibernateDaoSupport {
    @Autowired
    private SessionFactory factory;

       //查询所有
       public List<CrmCourseType> findAll(){
           System.out.println("进入action");
           String  hql= "from CrmCourseType";
           return (List<CrmCourseType>) this.getHibernateTemplate().find(hql);
       }



    //编辑 根据id查询
    public CrmCourseType findByid(String courseTypeId) {
        System.out.println("我是dao层");
        System.out.println("查询语句");
        return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);

    }

        //保存和更新
        public void update(CrmCourseType crmCourseType){
               this.getHibernateTemplate().saveOrUpdate(crmCourseType); ;
           }

    //高级查询
    public List<CrmCourseType> superSelect(String courseName,String remark,int totalStart, int totalEnd, int costStart, int costEnd) {


            //where 后面语句的拼接
            String str ="";
            if (courseName != null && !courseName.equals("")) {
                str += " s.courseName=:dn and";
            }
            if (remark != null && !remark.equals("")) {
                str += " s.remark=:pn and";
            }


            //拼接sql语句
            String hql = "from CrmCourseType as s where" + str;

            //对获取到的数据做判断
            if (totalStart != 0) {
                str = " total>=" + totalStart + " and";
                hql += str;
            }
            if (totalEnd != 0) {
                str = " total<=" + totalEnd + " and";
                hql += str;
            }
            if (costStart != 0) {
                str = " courseCost>=" + costStart + " and";
                hql += str;
            }
            if (costEnd != 0) {
                str = " courseCost<=" + costEnd + " and";
                hql += str;
            }


//        StringBuilder sb;
//        if(str!=null && !str.equals("")){
//            sb=new StringBuilder(str);
//            sb.insert(0," where ");
//            str = sb.toString();
//        }


            //对拼接的sql语句做判断
            if (hql.endsWith("and")) {
                hql = hql.substring(0, hql.length() - 3);
            }

            if (hql.endsWith("where")) {
                hql = hql.substring(0, hql.length() - 5);
            }

            System.out.println("拼接的" + "hql为:" + hql);
            Session session = factory.getCurrentSession();
            Query query = session.createQuery(hql);

            //对拼接成的语句的参数赋值
            if (courseName != null && !courseName.equals("")) {
                query.setParameter("dn", courseName);
            }
            if (remark != null && !remark.equals("")) {
                query.setParameter("pn", remark);
            }
            List<CrmCourseType> crmCourseTypes = query.list();
            return crmCourseTypes;
        }


}
