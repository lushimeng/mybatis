package com.atguigu.mapper;

import com.atguigu.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Mr.Lu
 * @Date 2022/12/12 15:43
 * @ClassName CacheMapper
 * @Version 1.0
 */
public interface CacheMapper {
    /**
     * 根据eid查询数据信息
     * @param eid
     */
    Emp getEmpByIdCache(@Param("eid") Integer eid);
}
