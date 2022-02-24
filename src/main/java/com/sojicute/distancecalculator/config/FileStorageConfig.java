package com.sojicute.distancecalculator.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FileStorageConfig {
    private String uploadDirectory = "files";

    public String getUploadDirectory() {
        return uploadDirectory;
    }

    public void setUploadDirectory(String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
    }
}
