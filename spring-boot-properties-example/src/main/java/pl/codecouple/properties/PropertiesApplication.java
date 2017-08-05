package pl.codecouple.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.codecouple.properties.custom.CustomProperties;

@SpringBootApplication
@EnableConfigurationProperties(CustomProperties.class)
public class PropertiesApplication implements CommandLineRunner{

	@Autowired
	CustomProperties customProperties;

	public static void main(String[] args) {
		SpringApplication.run(PropertiesApplication.class, args);

	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println(customProperties);
		System.out.println(customProperties.getPathMapper().get("first"));
		System.out.println(customProperties.getPathMapper().get("second"));
		System.out.println(customProperties.getPathMapper().get("third"));
	}
}
