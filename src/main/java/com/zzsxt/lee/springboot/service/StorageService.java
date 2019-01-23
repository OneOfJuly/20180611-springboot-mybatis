package com.zzsxt.lee.springboot.service;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @program: 20180611-springboot-mybatis
 * @Date: 2018/12/16 17:34
 * @Author: Mr.GUO
 * @Description:
 */
public interface StorageService {
    void init();
    void store(MultipartFile file, HttpServletRequest request);
    Stream<Path> loadAll();
    Path load(String filename);
    Resource loadAsResource(String filename);
    void deleteAll();
}
