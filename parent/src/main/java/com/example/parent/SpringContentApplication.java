package com.example.parent;

import com.example.child.repository.FileContentStore;
import com.example.child.repository.jpa.entity.File;
import com.example.child.repository.jpa.FileRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.example.*"})
@EnableScheduling
//@EnableFilesystemStores(basePackageClasses = FileContentStore.class)
@EnableJpaRepositories(basePackageClasses = FileRepository.class)
@EntityScan(basePackageClasses = File.class)
@PropertySource("classpath:config/child.properties")
public class SpringContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringContentApplication.class, args);
	}
}
