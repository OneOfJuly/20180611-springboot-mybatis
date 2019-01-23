package com.zzsxt.lee.springboot.service;

import com.zzsxt.lee.springboot.model.User;

import java.util.List;

/**
 * @Descriotion
 *      报错:Field userMapper in com.zzsxt.lee.springboot.service.UserService required a bean of type 'com.zzsxt.lee.springboot.mapper.UserMapper' that could not be found.
 *      原因:找不到mapper接口(*Mapper.java)，也就是说明springboot并不认识mybatis中的mapper接口
 *      解决:使用springboot自带的@Mapper注解来标识Mapper接口
 *
 *      !!!!!!当使用mapper注解的时候，一个项目中只能存在同类型的一个注解，绝对不允许存在两个同类型的注解
 *              UserMapper.java--->com.zzsxt.lee.springboot.mapper
 *              UserMapper.java--->com.zzsxt.lee.springboot.test
 * @Company 北京尚学堂
 * @Author Seven Lee
 * @Date 2018/6/11
 * @Time 10:04
 */

public interface UserService {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

}
