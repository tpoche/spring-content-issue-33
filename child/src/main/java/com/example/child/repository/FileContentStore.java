package com.example.child.repository;

import com.example.child.repository.jpa.entity.File;
import org.springframework.content.commons.repository.ContentStore;

public interface FileContentStore extends ContentStore<File, String> {
}
