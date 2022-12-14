package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.util.GetSqlSession;
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
 * @Date 2022/11/26 20:06
 * @ClassName MybatisTest
 * @Version 1.0
 */
public class MybatisTest {
    @Test
    public void testInsertUser() throws IOException {
        System.out.println("测试插入函数.................");
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        for(int i = 0; i < 10; i++){
            int count = userMapper.insertUser();

        }
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() throws IOException {
        System.out.println("测试更新函数.................");
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.updateUser(5);
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() throws IOException {
        System.out.println("测试删除函数.................");
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.deleteUser(10);
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        System.out.println("测试查询函数.................");
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(5);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testSelectAll() throws IOException {
        System.out.println("测试查询所有函数.................");
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        for(User user : users){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testMybatis() throws IOException {
        // 加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 通过工厂建造对象SqlSessionFactoryBuilder获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务,要不然提交失败，数据库不会发生变化
//         SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
         SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，
        // 通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句

        // 插入语句
        // int count = userMapper.insertUser();

        // 更新语句
        // int count = userMapper.updateUser(5);

        // 删除语句
        // int count = userMapper.deleteUser(6);

        // 根据id查询用户信息
        // User user = userMapper.selectById(5);
        // System.out.println(user);

        // 查询所有
        List<User> users = userMapper.selectAll();
        for(User user : users){
            System.out.println(user);
        }

        // 提交事务，与上面一一对应，如果设置为true，则下面这一行不需要
        // sqlSession.commit();

        // 关闭
        sqlSession.close();
    }
}
