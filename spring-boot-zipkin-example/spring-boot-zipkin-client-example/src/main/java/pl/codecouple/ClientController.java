package pl.codecouple;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Krzysztof Chruściel.
 */
@RestController
public class ClientController {

    private static final Logger LOG = Logger.getLogger(ClientController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/hello")
    String sayHello(){
        LOG.info("Hello from Client!");
        return restTemplate.getForEntity("http://localhost:8081/world", String.class).getBody();
    }

}
