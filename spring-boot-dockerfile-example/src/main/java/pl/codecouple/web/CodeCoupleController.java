package pl.codecouple.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CodeCouple.pl
 */
@RestController
@RequestMapping("/")
class CodeCoupleController {

    @GetMapping
    String getCodeCouple(){
        return "CodeCouple.pl";
    }

}
