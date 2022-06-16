package com.ning.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2022-06-16 10:51:05
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = 700491532342670996L;
    
    private String adminId;
    
    private String name;
    
    private String password;
    /**
     * 经理，职员
     */
    private String rank;


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}

