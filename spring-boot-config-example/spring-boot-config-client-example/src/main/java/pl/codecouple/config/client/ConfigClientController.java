package pl.codecouple.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Krzysztof Chruściel.
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${info.property}")
    private String property;

    @Value("${info.encrypted.property}")
    private String encrypted;

    @GetMapping("/message")
    String property() {
        return property;
    }

    @GetMapping("/decrypted")
    String decrypted() {
        return encrypted;
    }

}
