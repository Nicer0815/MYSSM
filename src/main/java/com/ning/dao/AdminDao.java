package com.ning.dao;

import com.ning.entity.Admin;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 10:55:57
 */
public interface AdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adminid 主键
     * @return 实例对象
     */
    Admin queryById(String adminid);



    /**
     * 统计总行数
     *
     * @param admin 查询条件
     * @return 总行数
     */
    long count(Admin admin);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);



    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param adminid 主键
     * @return 影响行数
     */
    int deleteById(String adminid);

}

