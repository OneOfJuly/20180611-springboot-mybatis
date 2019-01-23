package com.zzsxt.lee.springboot.service.impl;

import com.zzsxt.lee.springboot.model.StorageProperties;
import com.zzsxt.lee.springboot.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


/**
 * @program: 20180611-springboot-mybatis
 * @Date: 2018/12/16 17:38
 * @Author: Mr.GUO
 * @Description:
 */
@Service
public class FileSystemStorageServiceImpl implements StorageService {

    private final Path rootLocation;
    @Autowired
    public FileSystemStorageServiceImpl(StorageProperties properties) {

        this.rootLocation = Paths.get(properties.getLocation());
    }
    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void store(MultipartFile file, HttpServletRequest request) {
        String imgPath = request.getSession().getServletContext().getRealPath("/static/upload-files");
        File imgDir = new File(imgPath);
        if (!imgDir.exists()) {
            imgDir.mkdirs();
        }
        String oldFileName = file.getOriginalFilename();
        try {
            file.transferTo(new File(imgDir,oldFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path->this.rootLocation.relativize(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
