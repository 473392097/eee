package com.lanou.service;

import com.lanou.bean.CrmClasses;
import com.lanou.dao.CourseDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanouhn on 17/8/22.
 */

public class CourseService {
     private CourseDao courseDao;

     //查询所有
     public List<CrmClasses> findAll(){
          return courseDao.findAll();
     }



     public CrmClasses findByid(String classId) {

          return   courseDao.findByid(classId);
     }






     //编辑
     public  void update(CrmClasses crmClasses){
          courseDao.update(crmClasses);
     }


     public CourseDao getCourseDao() {
          return courseDao;
     }

     public void setCourseDao(CourseDao courseDao) {
          this.courseDao = courseDao;
     }




}
