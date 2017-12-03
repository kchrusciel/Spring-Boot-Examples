package pl.codecouple.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CodeCouple.pl
 */
@RestController
public class SecondController {

    @GetMapping("/codecouple")
    public String showCodeCouple() {
        return "CodeCouple second service!";
    }
}
