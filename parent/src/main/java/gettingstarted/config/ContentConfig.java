package gettingstarted.config;

import child.FileContentStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.content.fs.io.FileSystemResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Configuration
@EnableScheduling
@EnableFilesystemStores(basePackageClasses = FileContentStore.class)
public class ContentConfig {
    @Value("spring.content.fs.filesystemRoot")
    private String filesystemRoot;

    // getters & setters
    public String getFilesystemRoot() { return filesystemRoot; }
    public void setFilesystemRoot(String filesystemRoot) {
        this.filesystemRoot = filesystemRoot;
    }

    @Bean(name = "filesystemRoot")
    File rootFile() {
        if (StringUtils.hasText(getFilesystemRoot())) {
            return new File(getFilesystemRoot());
        }

        try {
            return Files.createTempDirectory("").toFile();
        } catch (IOException ioe) {
            return null;
        }
    }

    @Bean
    FileSystemResourceLoader fileSystemResourceLoader() {
        return new FileSystemResourceLoader(rootFile().getAbsolutePath());
    }
}
