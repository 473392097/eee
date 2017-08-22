package com.lanou.service;

import com.lanou.bean.CrmClasses;
import com.lanou.bean.CrmCourseType;
import com.lanou.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanouhn on 17/8/22.
 */
@Transactional
public class CourseService {
     @Autowired
     private CourseDao courseDao;

     //查询所有
     public List<CrmCourseType> findAll(){
          return courseDao.findAll();
     }



     public CrmCourseType findByid(String courseTypeId) {
          System.out.println("service层");
          return  courseDao.findByid(courseTypeId);
     }






     //编辑

     public  void update(CrmCourseType crmCourseType){
          courseDao.update(crmCourseType);
     }


     public CourseDao getCourseDao() {
          return courseDao;
     }

     public void setCourseDao(CourseDao courseDao) {
          this.courseDao = courseDao;
     }




}
