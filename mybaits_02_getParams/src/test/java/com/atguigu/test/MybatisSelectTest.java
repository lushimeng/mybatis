package com.atguigu.test;

import com.atguigu.mapper.SelectMapper;
import com.atguigu.pojo.User;
import com.atguigu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Mr.Lu
 * @Date 2022/11/30 19:40
 * @ClassName MybatisSelectTest
 * @Version 1.0
 */
public class MybatisSelectTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user = selectMapper.selectById(18);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userList = selectMapper.getUserList();
        for(User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        int count = selectMapper.getCount();
        System.out.println("t_user表中一共有" + count + "条数据");
        sqlSession.close();
    }

    @Test
    public void testGetUserToMap(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userToMap = selectMapper.getUserToMap(18);
        System.out.println(userToMap);
        sqlSession.close();
    }

    @Test
    public void testGetUserToMaps1(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> userToMaps = selectMapper.getUserToMaps1();
        for(Map<String, Object> map : userToMaps){
            System.out.println(map);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserToMaps2(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userToMaps2 = selectMapper.getUserToMaps2();
        System.out.println(userToMaps2);
        Set<Map.Entry<String, Object>> entries = userToMaps2.entrySet();
        for(Map.Entry<String, Object> entry : entries){
            System.out.println(entries);
        }
        sqlSession.close();
    }
}
