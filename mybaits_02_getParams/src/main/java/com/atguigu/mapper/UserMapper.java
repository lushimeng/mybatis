package com.atguigu.mapper;

import com.atguigu.pojo.User;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/11/27 10:38
 * @ClassName UserMapper
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();
}
