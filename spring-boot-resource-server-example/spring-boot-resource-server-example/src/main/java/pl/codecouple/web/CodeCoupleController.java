package pl.codecouple.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CodeCouple.pl
 */
@RestController
class CodeCoupleController {

    @GetMapping("/not-for-all")
    String showCodeCouple(){
        return "Code Couple!";
    }

}
