package com.abc.service.impl;

import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.Dept;
import com.abc.dao.idao.IDeptDao;
import com.abc.service.iservice.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("deptServiceI")
public class DeptServiceImpl implements IDeptService {
    @Autowired
    IDeptDao deptDao;

    @Override
    public Res<List<Dept>> findAll() {
        List<Dept> depts=new ArrayList<Dept>();
        try {
            depts=deptDao.findAll();
            System.out.println("*****************"+depts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Dept有效
        if (depts.size()>0){
            return Res.success(ResEnum.SUCCESSS,depts);
        }else {
            return Res.error();
        }
    }
}
