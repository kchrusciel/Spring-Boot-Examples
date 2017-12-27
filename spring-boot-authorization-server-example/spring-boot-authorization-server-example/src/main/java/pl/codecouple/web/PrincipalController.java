package pl.codecouple.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by CodeCouple.pl
 */
@RestController
class PrincipalController {

    @GetMapping("/user")
    Principal getPrinciapl(Principal principal){
        return principal;
    }

}
