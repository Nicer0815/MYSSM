package com.ning.entity;

import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2022-06-16 14:28:44
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = -16247750870489693L;
    
    private String customerId;
    
    private String name;
    
    private String sex;
    
    private Integer phoneNum;
    
    private Integer discount;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}

