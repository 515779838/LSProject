package com.example.lsproject.bean;

import java.io.Serializable;

/**
 * Created by caoyingfu on 2017/10/13.
 */

public class FileBean implements Serializable {

    private String fileUrl;
    private String fileName;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "fileUrl='" + fileUrl + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
