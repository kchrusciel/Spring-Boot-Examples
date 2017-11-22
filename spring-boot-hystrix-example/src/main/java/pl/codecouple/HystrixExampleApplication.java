package pl.codecouple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class HystrixExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixExampleApplication.class, args);
	}
}
