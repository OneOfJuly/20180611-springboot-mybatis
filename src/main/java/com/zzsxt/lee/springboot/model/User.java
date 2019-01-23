package com.zzsxt.lee.springboot.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.io.Serializable;

public class User  extends BaseRowModel implements Serializable {
    @ExcelProperty(value = "序号",index = 0)
    private Long id;

    @ExcelProperty(value = "用户名",index = 1)
    private String username;

    @ExcelProperty(value = "密码",index = 2)
    private String password;

    @ExcelProperty(value = "照片",index = 3)
    private String headPic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headPic='" + headPic + '\'' +
                '}';
    }
}