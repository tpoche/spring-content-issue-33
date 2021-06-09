package com.example.child.config;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class MyFileSystemResourceLoader extends org.springframework.content.fs.io.FileSystemResourceLoader {
    public MyFileSystemResourceLoader(String root) {
        super(root);
    }

    @Override
    public Resource getResource(String location) {
        Assert.notNull(getRootResource(), "resource root is required");
        Resource resource = getRootResource().createRelative(location);
        if (resource instanceof FileSystemResource) {
            resource = new MyFileSystemDeletableResource((FileSystemResource) resource);
        }
        return resource;
    }
}
