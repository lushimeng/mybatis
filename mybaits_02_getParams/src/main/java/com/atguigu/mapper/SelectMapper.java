package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.Lu
 * @Date 2022/11/30 19:37
 * @ClassName SelectMapper
 * @Version 1.0
 */
public interface SelectMapper {

    /**
     * 建议只分为map和实体类型两种，根据id查询用户信息
     * @param id
     * @return
     */
    User selectById(@Param("id") int id);

    /**
     * 得到用户集合
     * @return
     */
    List<User> getUserList();

    /**
     * 得到表中有多少个数据
     * @return
     */
    int getCount();

    /**
     * 根据用户id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserToMap(@Param("id") int id);

    /**
     * 得到数据表的map集合
     * 方式一：将表中的数据以map集合的方式查询，
     *        一条数据对应一个map；若有多条数据，就会产生多个map集合，此时可以将这些map放在一个list集合中获取
     *
     * 方式二：将表中的数据以map集合的方式查询，
     *        一条数据对应一个map；若有多条数据，就会产生多个map集合，并且最终要以一个map的方式返回数据，
     *        此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的map集合
     * @return
     */
    List<Map<String, Object>> getUserToMaps1();

    @MapKey("id")
    Map<String, Object> getUserToMaps2();


}
