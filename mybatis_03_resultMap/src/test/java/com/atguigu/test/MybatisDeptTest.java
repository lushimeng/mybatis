package com.atguigu.test;

import com.atguigu.mapper.DeptMapper;
import com.atguigu.pojo.Dept;
import com.atguigu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/2 19:13
 * @ClassName MybatisTest
 * @Version 1.0
 */
public class MybatisDeptTest {
    @Test
    public void testGetDeptAll(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptAll = deptMapper.getDeptAll();
        for(Dept dept : deptAll){
            System.out.println(dept);
        }
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptByStepTwo(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getEmpAndDeptByStepTwo(2);
        System.out.println(dept);
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmp(1);
        System.out.println(dept);
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmpOne(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpOne(1);
        System.out.println(dept);
        sqlSession.close();
    }
}
