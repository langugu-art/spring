package com.abc.dao.impl;

import com.abc.dao.entity.Dept;
import com.abc.dao.idao.IDeptDao;
import com.abc.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements IDeptDao {
//    相似findbypage
    @Override
    public List<Dept> findAll() throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="SELECT deptno,dname FROM dept";
        PreparedStatement pst=con.prepareStatement(sql);
        ResultSet rs=pst.executeQuery();
        List<Dept> depts=new ArrayList<Dept>();
        while (rs.next()){
            Dept dept=new Dept();
            dept.setDeptno(rs.getInt(1));
            dept.setDname(rs.getString(2));
            depts.add(dept);
        }
        DBUtil.close(rs,pst,con);
        return depts;
    }
}
