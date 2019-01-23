package com.zzsxt.lee.springboot.model;

/**
 * @program: 20180611-springboot-mybatis
 * @Date: 2018/12/16 17:27
 * @Author: Mr.GUO
 * @Description:
 */
public class Linker {
    private String fileUrl;
    private String fileName;

    public Linker(String serveFile, String toString) {

    }

    public String getFileName() {
        return fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }


}
