package pl.codecouple.update.todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Krzysztof Chruściel.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TodoNotFound extends Exception {

    public TodoNotFound() {
        super("Todo not found!");
    }

    public TodoNotFound(String message) {
        super(message);
    }
}
