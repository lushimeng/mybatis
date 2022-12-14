package com.atguigu.test;

import com.atguigu.mapper.DynamicSQLMapper;
import com.atguigu.mapper.EmpMapper;
import com.atguigu.pojo.Emp;
import com.atguigu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/11 10:05
 * @ClassName MybatisTest
 * @Version 1.0
 */
public class MybatisTest {

    @Test
    public void testGetEmpAll(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empList = mapper.getEmpAll();
        for(Emp emp : empList){
            System.out.println(emp);
        }
        sqlSession.close();
    }


    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 23, "男", "1234@qq.com");
        List<Emp> empList = dynamicSQLMapper.getEmpByConditionOne(emp);
        for(Emp emp1 : empList){
            System.out.println(emp1);
        }
        sqlSession.close();
    }

    @Test
    public void testGetEmpByConditionTwo(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 235, "", "");
        List<Emp> empList = dynamicSQLMapper.getEmpByConditionTwo(emp);
        System.out.println(empList);
        sqlSession.close();
    }

    @Test
    public void testGetEmpByConditionThree(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", null, "", "1234@qq.com1");
        List<Emp> empList = mapper.getEmpByConditionThree(emp);
        System.out.println(empList);
    }

    @Test
    public void testGetEmpByConditionFour(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "yxy", 231, "", "12341@qq.com");
        List<Emp> empList = mapper.getEmpByConditionFour(emp);
        System.out.println(empList);
        sqlSession.close();
    }

    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "a1", 10, "男", "1234@qq.com", null);
        Emp emp2 = new Emp(null, "a2", 10, "男", "1234@qq.com", null);
        Emp emp3 = new Emp(null, "a3", 10, "男", "1234@qq.com", null);
        Emp emp4 = new Emp(null, "a4", 10, "男", "1234@qq.com", null);
        Emp emp5 = new Emp(null, "a5", 10, "男", "1234@qq.com", null);
        Emp emp6 = new Emp(null, "a6", 10, "男", "1234@qq.com", null);

        List<Emp> empList = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
        int count = mapper.insertMoreByList(empList);
        System.out.println("受影响的行数：" + count);
    }

    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{15, 16, 17, 19, 19});
        System.out.println(result);
        sqlSession.close();
    }
}
