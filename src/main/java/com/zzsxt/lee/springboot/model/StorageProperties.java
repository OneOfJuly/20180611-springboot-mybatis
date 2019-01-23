package com.zzsxt.lee.springboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: 20180611-springboot-mybatis
 * @Date: 2018/12/16 17:46
 * @Author: Mr.GUO
 * @Description:
 */
@ConfigurationProperties("storage")
public class StorageProperties {



    private String location = "/static/upload-files/";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}