package com.atuguigu.test;

import com.atguigu.mapper.EmpMapper;
import com.atguigu.pojo.Emp;
import com.atguigu.pojo.EmpExample;
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
 * @Date 2022/12/13 11:11
 * @ClassName TestEmpMapper
 * @Version 1.0
 */
public class TestEmpMapper {
    @Test
    public void testMethod(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            // 根据条件查询
            EmpExample empExample = new EmpExample();
            // 标准一：name为lsm且年龄等于231
            empExample.createCriteria().andEmpNameEqualTo("lsm").andAgeEqualTo(231);
            // 标准二与标准一or的关系，did不为空
            empExample.or().andDidIsNotNull();
            List<Emp> empList = empMapper.selectByExample(empExample);
            empList.forEach(emp -> System.out.println(emp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






















