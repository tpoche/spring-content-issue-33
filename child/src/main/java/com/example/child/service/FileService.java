package com.example.child.service;

import com.example.child.repository.jpa.entity.File;

import java.io.InputStream;

public interface FileService {
    File create(File f);
    File saveContent(Long id, String contentType, InputStream inputStream);
    StreamInfo getContent(Long id);
}
