package com.lanou.service;

import com.lanou.bean.CrmDepartment;
import com.lanou.bean.CrmPost;
import com.lanou.bean.CrmStaff;
import com.lanou.dao.StaffDaoImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanouhn on 17/8/16.
 */


@Transactional(readOnly = false)
public class StaffServiceImpl implements StaffService {

    private StaffDaoImpl staffDao;


    @Override
    //登录
    public CrmStaff login(CrmStaff crmStaff) {
        System.out.println("我是service层");
        CrmStaff crmStaff2 =  staffDao.find(crmStaff.getLoginName(),crmStaff.getLoginPwd());
        return crmStaff2;
    }





     //员工管理
    public List<CrmStaff> findAllStaff() {
        return staffDao.findAll();
    }

    @Override
    //基本职务回显
    public CrmStaff findByid(String staffId) {
        return staffDao.findByid(staffId);
    }

    @Override
    public List<CrmDepartment> findDepart() {
        return  staffDao.findDepart();
    }

    @Override
    public String update(CrmStaff crmStaff) {
        staffDao.update(crmStaff);
        return null;
    }

    @Override
    public void save(CrmStaff crmStaff) {
        System.out.println("我是service层");
        staffDao.save(crmStaff);
    }

    public List<CrmStaff> limitSelct(String staffName,String postName,String depName){
        return staffDao.limitSelect(staffName,postName,depName);

    }


    public StaffDaoImpl getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDaoImpl staffDao) {
        this.staffDao = staffDao;
    }
}
