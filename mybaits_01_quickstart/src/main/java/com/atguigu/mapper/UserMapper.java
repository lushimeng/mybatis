package com.atguigu.mapper;

import com.atguigu.pojo.User;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/11/26 16:45
 * @ClassName UserMapper
 * @Version 1.0
 * 相当于dao层，数据库表为t_user，那么实体类就是User,
 * 对应的dao层或者mapper层为UserDao或者UserMapper
 */

public interface UserMapper {
    /**
     * MyBatis面向接口编程的两个一致:
     * 1、映射文件(xxxMapper.xml)的namespace要和mapper层(dao层)接口的全类名保持一致;
     * 2、映射文件(xxxMapper.xml)中SQL语句的id要和mapper层接口中的方法名一致;
     * @return
     */

    /**
     * 添加用户的信息
     * @return
     */
    int insertUser();

    /**
     * 更新用户信息
     * @param id
     * @return
     */
    int updateUser(int id);

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    int deleteUser(int id);


    /**
     * 根据id查询用户数据
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 查询数据库所有信息
     * @return
     */
    List<User> selectAll();
}
