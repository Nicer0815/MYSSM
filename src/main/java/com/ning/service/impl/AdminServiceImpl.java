package com.ning.service.impl;

import com.ning.entity.Admin;
import com.ning.dao.AdminDao;
import com.ning.service.AdminService;
import com.ning.service.AdminService;
import org.springframework.stereotype.Service;


/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:55:57
 */
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adminid 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(String adminid) {
        return this.adminDao.queryById(adminid);
    }


    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getAdminId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adminid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String adminid) {
        return this.adminDao.deleteById(adminid) > 0;
    }
}
