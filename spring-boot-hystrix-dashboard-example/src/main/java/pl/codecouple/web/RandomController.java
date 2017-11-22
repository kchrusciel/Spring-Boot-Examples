package pl.codecouple.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by CodeCouple.pl
 */
@RestController
class RandomController {

    @GetMapping("/")
    @HystrixCommand(fallbackMethod = "fallback")
    String getRandomNumber() throws InterruptedException {
        int result = new Random().nextInt(10);
        if (result > 5) {
            throw new RuntimeException("¯\\_(ツ)_/¯");
        }
        return String.format("The number is {%d}", result);
    }

    String fallback(){
        return "Hystrix is working!";
    }

}
