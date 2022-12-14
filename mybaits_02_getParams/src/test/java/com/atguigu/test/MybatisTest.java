package com.atguigu.test;

import com.atguigu.mapper.ParameterMapper;
import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mr.Lu
 * @Date 2022/11/27 11:01
 * @ClassName MybatisTest
 * @Version 1.0
 */
public class MybatisTest {
    /**
     * Mybatis获取参数方式 ${} 和 #{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     * Mybatis获取参数值的各种情况
     * 1、mapper接口方法的参数为单个的字面量类型
     *  可以通过${} 和 #{} 以任意的名称获取参数值，但是需要注意${}的单引号问题
     *
     * 2、mapper接口方法的参数为多个时
     *   此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储：
     *   a> 以arg0, arg1...为键，以参数为值
     *   b> 以param1 , param2...为键，以参数为值
     *  因此只需要通过#{}和${}键的方式访问值即可，但是需要注意${}的单引号问题
     *
     * 3、若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     *   只需要通过#{}和 ${}以键的方式访问值即可，但是需要注意${}的单引号问题
     *
     * 4、若mapper接口中实的方法参数为体类对象时此时可以使用${}和#{}，
     *   通过===访问实体类对象中的属性名获取属性值====，注意**${}需要手动加单引号**
     *
     * 5、@Param注解
     *   a> 以@Param注解的value属性值为键，以参数为值；
     *   b> 以param1,param2...为键，以参数为值；
     */

    @Test
    public void testSelectAll() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> users = mapper.selectAll();
        for(User user : users){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserByUserName(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.getUserByUserName("lsm_yxy");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetUserByIdAndUsernameAndPassword(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.getUserByIdAndUsernameAndPassword(9, "lsm3", "1234");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        // 把登录验证信息封装成一个map集合，把map集合当做一个参数
        map.put("username", "lsm_yxy");
        map.put("password", "123456");
        User user = parameterMapper.checkLoginByMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = new User(null, "tom", "root", 10, "男", "123456@.com");
        int count = parameterMapper.insertUser(user);
        System.out.println("count: " + count);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.checkLoginByParam("lsm_yxy", "123456");
        System.out.println(user);
        sqlSession.close();
    }
}










