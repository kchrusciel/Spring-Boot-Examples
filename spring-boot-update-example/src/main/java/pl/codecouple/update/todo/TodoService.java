package pl.codecouple.update.todo;

import org.springframework.stereotype.Service;

/**
 * Created by Krzysztof Chruściel.
 */
@Service
public class TodoService {


    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public void addNewTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void update(Todo todo) {
        todoRepository.save(todo);
    }

    public Todo getTodoById(Long id){
        return todoRepository.findOne(id);
    }

    public void partialUpdated(Todo todo) {
        todoRepository.save(todo);
    }
}
