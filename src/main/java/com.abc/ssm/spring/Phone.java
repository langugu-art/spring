package com.abc.ssm.spring;

import java.math.BigDecimal;

public class Phone {
    //品牌
    private String brand;
    //价格
    private BigDecimal price;

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public Phone(String brand, BigDecimal price) {
        this.brand = brand;
        this.price = price;
    }

    public Phone() {

    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
