package com.abc.ssm.spring;

import java.io.Serializable;

public class Person implements Serializable {
    private int pId;
    private  String pName;
    private Phone phone;

    @Override
    public String toString() {
        return "Person{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", phone=" + phone +
                '}';
    }

    public Person(int pId, String pName, Phone phone) {
        this.pId = pId;
        this.pName = pName;
        this.phone = phone;
    }

    public Person() {
    }

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
