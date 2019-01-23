package com.zzsxt.lee.springboot.service;

import org.springframework.core.io.InputStreamSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: 20180611-springboot-mybatis
 * @Date: 2018/12/16 17:41
 * @Author: Mr.GUO
 * @Description:
 */
public interface MultipartFile extends InputStreamSource {

    String getName();
    String getOriginalFilename();
    String getContentType();
    boolean isEmpty();
    long getSize();
    byte[] getBytes() throws IOException;
    InputStream getInputStream() throws IOException;
    void transferTo(File dest) throws IOException, IllegalStateException;
}
