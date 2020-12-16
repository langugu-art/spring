package com.abc.service.dto;

import java.math.BigDecimal;

public class DeptEmpDTO {
    //返回集合，必须封装
    private String dname;
    private String loc;
    private String ename;
    private BigDecimal sal;

    @Override
    public String toString() {
        return "DeptEmpDTO{" +
                "dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                '}';
    }

    public DeptEmpDTO(String dname, String loc, String ename, BigDecimal sal) {
        this.dname = dname;
        this.loc = loc;
        this.ename = ename;
        this.sal = sal;
    }

    public String getDname() {
        return dname;
    }

    public String getLoc() {
        return loc;
    }

    public String getEname() {
        return ename;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }
}
