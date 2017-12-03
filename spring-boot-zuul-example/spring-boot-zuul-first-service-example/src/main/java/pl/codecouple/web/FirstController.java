package pl.codecouple.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by CodeCouple.pl
 */
@RestController
public class FirstController {

    @GetMapping("/codecouple")
    public String showCodeCouple(HttpServletRequest request) {
        return "CodeCouple first service!";
    }
}
