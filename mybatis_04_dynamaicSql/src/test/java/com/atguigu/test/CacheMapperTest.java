package com.atguigu.test;

import com.atguigu.mapper.CacheMapper;
import com.atguigu.pojo.Emp;
import com.atguigu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @Author Mr.Lu
 * @Date 2022/12/12 15:45
 * @ClassName CacheMapperTest
 * @Version 1.0
 */
public class CacheMapperTest {
    @Test
    public void testGetEmpByIdOne(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByIdCache(1);
        System.out.println(emp1);
        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpByIdCache(1);
        System.out.println(emp2);
    }

    /**
     * Mybatis自动提交： 对数据库的增删改才提交事务，对查询操作不提交事务。
     */
    @Test
    public void testGetEmpByIdTwo(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByIdCache(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpByIdCache(1);
        System.out.println(emp2);
        sqlSession2.close();


    }
}
