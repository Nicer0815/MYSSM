package com.ning.service;

import com.ning.entity.Admin;


/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 10:55:57
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param adminid 主键
     * @return 实例对象
     */
    Admin queryById(String adminid);


    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param adminid 主键
     * @return 是否成功
     */
    boolean deleteById(String adminid);

}
