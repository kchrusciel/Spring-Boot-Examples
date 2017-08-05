package pl.codecouple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Krzysztof Chruściel.
 */
@RestController
public class CodeCoupleController {

    private final RestTemplate restTemplate;

    public CodeCoupleController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/show")
    public String showCodeCoupleRoxx(){
        return restTemplate.getForObject("http://client-example/codecouple", String.class) + " Roxx!";
    }
}
