package com.atguigu.test;

import com.atguigu.mapper.EmpMapper;
import com.atguigu.pojo.Emp;
import com.atguigu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/2 19:18
 * @ClassName MybatisEmpTest
 * @Version 1.0
 */
public class MybatisEmpTest {
    @Test
    public void testGetEmpAll(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empAll = empMapper.getEmpAll();
        for(Emp emp : empAll){
            System.out.println(emp);
        }
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptById(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptById(3);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptByStepTwoAndOne(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByStepOne(4);
        System.out.println(emp.getEmpName());
        System.out.println("===============================");
        System.out.println(emp.getDept());
        sqlSession.close();
    }
}
