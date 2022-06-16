package com.ning.service.impl;

import com.ning.entity.Admin;
import com.ning.dao.AdminMapper;
import com.ning.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin queryById(String adminId) {

        return this.adminMapper.queryById(adminId);
    }


    @Override
    public Admin insert(Admin admin) {
        this.adminMapper.insert(admin);
        return admin;
    }

    @Override
    public Admin update(Admin admin) {
        this.adminMapper.update(admin);
        return this.queryById(admin.getAdminId());
    }

    @Override
    public List<Admin> queryAll() {
        System.out.println("adminServiceImpl==>queryAll"+adminMapper);
        return adminMapper.queryAll();
    }

    @Override
    public boolean deleteById(String adminId) {
        return this.adminMapper.deleteById(adminId) > 0;
    }
}
