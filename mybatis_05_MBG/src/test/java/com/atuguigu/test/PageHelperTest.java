package com.atuguigu.test;

import com.atguigu.mapper.EmpMapper;
import com.atguigu.pojo.Emp;
import com.atguigu.util.SqlSessionFactoryUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/13 19:59
 * @ClassName PageHelperTest
 * @Version 1.0
 */
public class PageHelperTest {
    @Test
    public void testPageHelper1(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 访问2页，每页4条数据
        PageHelper.startPage(2, 4);
        List<Emp> empList = mapper.selectByExample(null);
        empList.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void testPageHelper2(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 访问一页，每页四条数据
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> empList = mapper.selectByExample(null);
        // 在查询到List集合后，打印分页数据
        System.out.println(page);
    }

    @Test
    public void testPageHelper3(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 访问一页，每页四条数据
        PageHelper.startPage(2, 4);
        List<Emp> empList = mapper.selectByExample(null);
        PageInfo<Emp> page = new PageInfo<>(empList, 5);
        System.out.println(page);
    }

}
