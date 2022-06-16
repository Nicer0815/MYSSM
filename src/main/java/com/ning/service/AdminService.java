package com.ning.service;

import com.ning.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    Admin queryById(String adminId);


    Admin insert(Admin admin);

    Admin update(Admin admin);

    List<Admin> queryAll();

    boolean deleteById(String adminId);

}
