package com.lanou.service;

import com.lanou.bean.CrmDepartment;
import com.lanou.dao.DepartDaoImpl;

import java.util.List;

/**
 * Created by lanouhn on 17/8/18.
 */
public class DepartServiceImpl {
    private DepartDaoImpl departDao ;
    public List<CrmDepartment> findDepart(){

        return  null;
    }





    public DepartDaoImpl getDepartDao() {
        return departDao;
    }

    public void setDepartDao(DepartDaoImpl departDao) {
        this.departDao = departDao;
    }
}
