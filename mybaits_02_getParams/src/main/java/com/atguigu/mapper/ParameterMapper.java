package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.Lu
 * @Date 2022/11/27 10:57
 * @ClassName ParameterMapper
 * @Version 1.0
 */
public interface ParameterMapper {

    /**
     * 根据username获取对象
     * @param username
     * @return
     */
    User getUserByUserName(String username);

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();

    /**
     * 根据id、username、password获取对象
     * @param id
     * @param username
     * @param password
     * @return
     */
    User getUserByIdAndUsernameAndPassword(int id, String username, String password);

    /**
     * 测试登录功能
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);


    /**
     * 根据@Param进行登录
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);


    /**
     * 插入一条用户数据
     * @param user
     * @return
     */
    int insertUser(User user);
}
