package gettingstarted;

import child.File;
import child.FileContentController;
import child.FileContentStore;
import child.FileRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = FileRepository.class)
@EnableFilesystemStores(basePackageClasses = FileContentStore.class)
@ComponentScan(basePackageClasses = FileContentController.class)
@EntityScan(basePackageClasses = File.class)
public class SpringContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringContentApplication.class, args);
	}
}
