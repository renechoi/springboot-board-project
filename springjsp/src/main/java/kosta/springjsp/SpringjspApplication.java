package kosta.springjsp;

import kosta.springjsp.config.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(MyBatisConfig.class)
@SpringBootApplication(scanBasePackages = "kosta.springjsp.web")
public class SpringjspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjspApplication.class, args);
	}

}
