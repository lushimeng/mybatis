package com.atguigu.mapper;

import com.atguigu.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/11 10:25
 * @ClassName DynamicSQLMapper
 * @Version 1.0
 */
public interface DynamicSQLMapper {
    /**
     * 获取t_emp表的所有数据
     * @return
     */
    public List<Emp> getEmpAll();


    /**
     * 测试if标签使用，返回Emp的list集合
     * @param emp
     * @return
     */
    public List<Emp> getEmpByConditionOne(Emp emp);

    /**
     * 测试where标签的使用，返回Emp的List集合
     * @return
     */
    public List<Emp> getEmpByConditionTwo(Emp emp);

    /**
     * 测试trim标签，返回Emp的List集合
     * @param emp
     * @return
     */
    public List<Emp> getEmpByConditionThree(Emp emp);

    /**
     * 测试choose,when,otherwise标签,
     * @param emp
     * @return
     */
    public List<Emp> getEmpByConditionFour(Emp emp);

    /**
     * 使用foreach标签实现批量添加
     * @param emps
     * @return
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

    /**
     * 使用foreach标签实现批量删除
     * @param eids
     * @return
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

}
