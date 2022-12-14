package com.atguigu.mapper;

import com.atguigu.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/2 19:10
 * @ClassName DeptMapper
 * @Version 1.0
 */
public interface DeptMapper {
    /**
     * 获取t_dept表的全部数据
     * @return
     */
    List<Dept> getDeptAll();

    /**
     * 根据did查询部门信息
     * @param did
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 根据did查询部门信息以及其所包含的员工信息
     * @param did
     * @return
     */
    Dept getDeptAndEmp(@Param("did") Integer did);


    /**
     * 根据部分的did查询属于该部分的所有员工信息
     * @param did
     * @return
     */
    Dept getDeptAndEmpOne(@Param("did") Integer did);
}
