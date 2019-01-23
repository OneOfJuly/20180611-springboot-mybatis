package com.zzsxt.lee.springboot.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.Charset;

/**
 * @Descriotion
 *      springmvc的utf-8编码转换和json格式化
 * @Company 北京尚学堂
 * @Author Seven Lee
 * @Date 2018/6/11
 * @Time 10:00
 */
@SpringBootApplication
public class SpringMvcConfig {

    @Bean
    public StringHttpMessageConverter utf8Converter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter jsonConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setPrettyPrint(true);
        return converter;
    }

}
