package com.example.child.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.content.fs.io.FileSystemResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContentStoreConfig {
    @Value("${spring.content.fs.filesystemRoot}")
    private String contentStoragePath;

    @Bean
    FileSystemResourceLoader fileSystemResourceLoader() {
        return new MyFileSystemResourceLoader(contentStoragePath);
    }
}
