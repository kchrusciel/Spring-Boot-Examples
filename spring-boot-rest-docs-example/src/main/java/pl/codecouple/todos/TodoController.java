package pl.codecouple.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Krzysztof Chruściel.
 */
@RestController
@RequestMapping("/todos")
class TodoController {

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    Todo getTodoByTitle(@RequestParam(value = "title", required = true) String title){
        return new Todo(1l, "TDD", "Description");
    }

}
