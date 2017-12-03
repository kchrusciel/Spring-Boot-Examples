package pl.codecouple.consumer;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by CodeCouple.pl
 */
@RestController
class ConsumerController {

    private final RestTemplate restTemplate;

    ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    ResponseEntity<String> showCodeCouple(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://producer-service/",
                HttpMethod.GET,
                entity,
                String.class);
    }
}
