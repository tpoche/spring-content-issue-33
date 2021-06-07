package gettingstarted;

import child.File;
import child.FileRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"child", "gettingstarted"})
@EnableJpaRepositories(basePackageClasses = FileRepository.class)
@EntityScan(basePackageClasses = File.class)
public class SpringContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringContentApplication.class, args);
	}
}
