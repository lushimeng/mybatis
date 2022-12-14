package com.atguigu.mapper;

import com.atguigu.pojo.Emp;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/11 9:56
 * @ClassName EmpMapper
 * @Version 1.0
 */
public interface EmpMapper {
    /**
     * 得到t_emp表中的所有数据
     * @return
     */
    List<Emp> getEmpAll();
}


