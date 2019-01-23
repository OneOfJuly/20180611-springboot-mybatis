package com.zzsxt.lee.springboot.mapper;

import com.zzsxt.lee.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}