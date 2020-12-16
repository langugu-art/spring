package com.abc.dao.impl;

import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IEmpDao;
import com.abc.dao.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("empDao")
public class EmpDaoImpl implements IEmpDao {

    @Override
    public List<Emp> findByPage(int start, int size) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,hiredate,sal FROM emp limit ?,?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, start);
        pst.setInt(2, size);
        ResultSet rs = pst.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while (rs.next()) {
            Emp emp = new Emp(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs, pst, con);
        return emps;
    }

    @Override
    public List<Emp> findByName(String ename) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,hiredate,sal FROM emp WHERE ename LIKE ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        //!!!!少写语句
        pst.setString(1, "%" + ename + "%");
        ResultSet rs = pst.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while (rs.next()) {
            Emp emp = new Emp(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs, pst, con);
        return emps;
    }

    @Override
    public Emp findById(Integer empno) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,hiredate,sal FROM emp WHERE empno=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, empno);
        ResultSet rs = pst.executeQuery();
        Emp emp = null;
        if (rs.next()) {
            emp = new Emp(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBigDecimal(4));
        }
        DBUtil.close(rs, pst, con);
        return emp;
    }

    @Override
    public void delete(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "DELETE FROM emp WHERE empno=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, emp.getEmpno());
        //!!!!!!!执行语句写错，数据库没连接，写多余的语句
        pst.executeUpdate();
        //!!!!!!
//        ResultSet rs = pst.executeQuery();
        DBUtil.close(null, pst, con);
    }

    @Override
    public void save(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "insert into emp(ename,hiredate,sal) values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(3,emp.getSal());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public void update(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "update emp set ename=?,hiredate=?,sal=? where empno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(3,emp.getSal());
        ps.setInt(4,emp.getEmpno());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public List<Emp> findByDept(int deptno) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select empno,ename,hiredate,sal from emp where deptno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,deptno);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public void delBathch(List<DelVO> delVOList) throws Exception {
        Connection con = DBUtil.getConnection();
        StringBuilder buffer = new StringBuilder("delete from emp where empno in (");
        for(int i=0;i<delVOList.size();i++){
            if(i == delVOList.size()-1){
                buffer.append(delVOList.get(i).getEmpno()+")");
            }else{
                buffer.append(delVOList.get(i).getEmpno()+",");
            }
        }
        String sql = buffer.toString();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        DBUtil.close(null,ps,con);

//不推荐使用
//        Connection con = DBUtil.getConnection();
//        con.setAutoCommit(false);//1-关闭自动提交
//        Statement ps = con.createStatement();
//        try {
//            for (DelVO dv : delVOList) {
//                String sql = "delete from emp where empno=" + dv.getEmpno();
//                ps.addBatch(sql);
//            }
//            ps.executeBatch();
//            con.commit();//2-执行成功，手动提交
//        }catch(Exception e){
//            e.printStackTrace();
//            con.rollback();//3-出现异常，数据库回滚
//        }
//        DBUtil.close(null, ps, con);
    }
}
