package pl.codecouple.producer;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CodeCouple.pl
 */
@RestController
class UserController {

    @GetMapping("/")
    UserDTO getUser(){
        return UserDTO.builder()
                .id(1)
                .name("CodeCouple.pl")
                .build();
    }

}

@Builder
@Data
class UserDTO {
    private long id;
    private String name;
}
