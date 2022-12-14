package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/2 15:20
 * @ClassName SqlMapper
 * @Version 1.0
 */
public interface SqlMapper {

    /**
     * 根据用户名进行模糊查询
     * @param moHu
     * @return
     */
    List<User> getUserByLike(@Param("moHu") String moHu);

    /**
     * 根据id进行批量删除
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);


    /**
     * 查询指定表中的数据
     * @param tableName
     * @return
     */
    List<User> getUserByTable(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     * @param user
     */
    void insert(User user);
}
