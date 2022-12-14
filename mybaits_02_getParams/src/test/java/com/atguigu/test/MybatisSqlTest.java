package com.atguigu.test;

import com.atguigu.mapper.SqlMapper;
import com.atguigu.pojo.User;
import com.atguigu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/2 15:21
 * @ClassName MybatisSqlTest
 * @Version 1.0
 */
public class MybatisSqlTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        SqlMapper sqlMapper = sqlSession.getMapper(SqlMapper.class);
        List<User> userList = sqlMapper.getUserByLike("sm");
        for(User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public void testDeleteMore() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlMapper sqlMapper = sqlSession.getMapper(SqlMapper.class);
        int count = sqlMapper.deleteMore("22, 23, 24");
        System.out.println("影响行数：" + count);
        sqlSession.close();
    }

    @Test
    public void testGetUserByTable() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlMapper sqlMapper = sqlSession.getMapper(SqlMapper.class);
        List<User> userList = sqlMapper.getUserByTable("t_user");
        for(User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        // 可以获取插入数据的id
        User user = new User(null, "Tom", "123", 23, "男", "1235@qq.com");
        mapper.insert(user);
        System.out.println(user);
        sqlSession.close();
    }
}
