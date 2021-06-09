package com.example.child.config;

import internal.org.springframework.content.fs.io.FileSystemDeletableResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class MyFileSystemDeletableResource extends FileSystemDeletableResource {
    private static final Logger LOG = LoggerFactory.getLogger(MyFileSystemDeletableResource.class);
    private FileSystemResource resource;

    public MyFileSystemDeletableResource(FileSystemResource resource) {
        super(resource);
        this.resource = resource;
    }

    /**
     * FileUtils.touch method is using File.setLastModified to create a file if it does not exist. This method returns false
     * in Azure environments when running the containers within openshift.
     * @return
     * @throws IOException
     */
    @Override
    public OutputStream getOutputStream() throws IOException {
        if (!exists()) {
            //FileUtils.touch(this.getFile());
            Files.createFile(this.getFile().toPath());
        }
        return resource.getOutputStream();
    }
}
