package com.ning.dao;

import com.ning.entity.Admin;

import java.util.List;

public interface AdminMapper {

    Admin queryById(String adminId);

    List<Admin> queryAll();

    int insert(Admin admin);


    int update(Admin admin);

    int deleteById(String adminId);

}

