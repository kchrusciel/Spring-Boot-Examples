package pl.codecouple.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CodeCouple.pl
 */
@RestController
@RequestMapping("/")
public class HystrixController {

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping
    String hystrixMethod(){
        if (RandomUtils.nextInt(10) > 5) {
            return "Bingo!";
        }
        throw new RuntimeException();
    }

    String fallback(){
        return "Fallback";
    }

}
