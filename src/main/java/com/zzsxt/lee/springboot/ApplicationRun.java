package com.zzsxt.lee.springboot;

import com.zzsxt.lee.springboot.model.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Descriotion springboot的启动类
 * 当springboot集成mybatis的时候，必须要加载数据库的驱动类(Class.forName("com.mybatis.jdbc.Driver"))
 * 如果没有加载驱动，则报错！
 * @Company 北京尚学堂
 * @Author Seven Lee
 * @Date 2018/6/11
 * @Time 9:56
 */

@MapperScan("com.zzsxt.lee.springboot.mapper")
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ApplicationRun {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationRun.class, args);

    }

}
