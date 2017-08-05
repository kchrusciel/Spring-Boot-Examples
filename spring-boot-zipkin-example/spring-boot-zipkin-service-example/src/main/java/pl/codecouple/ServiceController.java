package pl.codecouple;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Krzysztof Chruściel.
 */
@RestController
public class ServiceController {

    private static final Logger LOG = Logger.getLogger(ServiceController.class.getName());

    @GetMapping("/world")
    String sayWorld(){
        LOG.info("Hello from Service!");
        return "World";
    }

}
