package com.atguigu.mapper;

import com.atguigu.pojo.Dept;
import com.atguigu.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/2 19:10
 * @ClassName EmpMapper
 * @Version 1.0
 */
public interface EmpMapper {
    /**
     * 获取表t_Emp的所有信息
     * @return
     */
    List<Emp> getEmpAll();


    /**
     * 根据t_emp表的eid查询emp和dept表，最后封装成Emp对象返回
     * @param eid
     * @return
     */
    Emp getEmpAndDeptById(Integer eid);


    /**
     * 分布查询，员工及所对应的部门信息
     * 查询员工信息
     * @param eid
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 根据did查询员工集合
     * @param did
     * @return
     */
    List<Emp> getDeptAndEmpTwo(@Param("did") Integer did);
}



















