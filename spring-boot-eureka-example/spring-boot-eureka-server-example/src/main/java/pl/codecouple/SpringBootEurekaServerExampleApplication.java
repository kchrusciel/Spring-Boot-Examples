package pl.codecouple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootEurekaServerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaServerExampleApplication.class, args);
	}
}
