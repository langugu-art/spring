package com.abc.controller.vo;

import java.math.BigDecimal;

public class DeptEmpVo {
    private int deptno;
    private BigDecimal minSal;
    private BigDecimal maxSal;

    @Override
    public String toString() {
        return "DeptEmpVo{" +
                "deptno='" + deptno + '\'' +
                ", minSal=" + minSal +
                ", maxSal=" + maxSal +
                '}';
    }

    public DeptEmpVo(int deptno, BigDecimal minSal, BigDecimal maxSal) {
        this.deptno = deptno;
        this.minSal = minSal;
        this.maxSal = maxSal;
    }

    public DeptEmpVo( ) {

    }

    public int getDeptno() {
        return deptno;
    }

    public BigDecimal getMinSal() {
        return minSal;
    }

    public BigDecimal getMaxSal() {
        return maxSal;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public void setMinSal(BigDecimal minSal) {
        this.minSal = minSal;
    }

    public void setMaxSal(BigDecimal maxSal) {
        this.maxSal = maxSal;
    }
}
