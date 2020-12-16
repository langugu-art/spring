package com.abc.dao.impl;

import com.abc.controller.vo.DeptEmpVo;
import com.abc.dao.idao.IReportDao;
import com.abc.dao.util.DBUtil;
import com.abc.service.dto.DeptEmpDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportDeptEmpDaoImpl  implements IReportDao {

    @Override
    public List<DeptEmpDTO> makeReportForDeptEmp(DeptEmpVo deptEmpVo) throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="SELECT d.dname,d.loc,e.ename,e.sal FROM dept d LEFT JOIN emp e " +
                "ON d.deptno=e.deptno WHERE d.deptno=? and e.sal between ? and ?";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1,deptEmpVo.getDeptno());
        pst.setBigDecimal(2,deptEmpVo.getMinSal());
        pst.setBigDecimal(3,deptEmpVo.getMaxSal());
        ResultSet rs=pst.executeQuery();
        List<DeptEmpDTO> dtos=new ArrayList<DeptEmpDTO>();
        while (rs.next()){
            DeptEmpDTO ded=new DeptEmpDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4));
            dtos.add(ded);
        }
        DBUtil.close(rs,pst,con);
        return dtos;
    }
}
