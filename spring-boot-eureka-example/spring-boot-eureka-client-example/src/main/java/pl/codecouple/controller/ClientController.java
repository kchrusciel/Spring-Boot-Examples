package pl.codecouple.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Krzysztof Chruściel.
 */
@RestController
public class ClientController {

    @GetMapping("/codecouple")
    public String showCodeCouple() {
        return "CodeCouple";
    }
}
