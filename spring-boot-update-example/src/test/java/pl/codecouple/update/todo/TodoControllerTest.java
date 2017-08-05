package pl.codecouple.update.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Krzysztof Chruściel.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    TodoService todoService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldAddNewTodo() throws Exception {
        // Given
        Todo todo = new Todo("Title", "Description");
        // When
        ResultActions result = this.mvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(todo)));
        // Then
        result.andExpect(status().isCreated())
                .andExpect(status().reason("Todo created!"));
    }

    @Test
    public void shouldReturn404WhenTryPartialUpdateTodoWhichNotExists() throws Exception {
        // Given
        given(todoService.getTodoById(anyLong())).willReturn(null);
        HashMap<String, Object> updates = new HashMap<>();
        updates.put("description", "new description");
        // When
        ResultActions result = this.mvc.perform(patch("/todos/10")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(updates)));
        // Then
        result.andExpect(status().isNotFound());
    }

    @Test
    public void shouldPartialUpdateTodo() throws Exception {
        // Given
        Todo todo = new Todo(1L, "title", "desc");
        given(todoService.getTodoById(1L)).willReturn(todo);
        HashMap<String, Object> updates = new HashMap<>();
        updates.put("title", "new title");
        updates.put("description", "new description");
        // When
        ResultActions result = this.mvc.perform(patch("/todos/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(updates)));
        // Then
        result.andExpect(status().isNoContent())
                .andExpect(status().reason("Todo partial updated!"));
    }


    @Test
    public void shouldCreateNewTodoWhenTryToUpdate() throws Exception {
        // Given
        given(todoService.getTodoById(anyLong())).willReturn(null);
        Todo todo = new Todo("New Title", "New Description");
        // When
        ResultActions result = this.mvc.perform(put("/todos/10")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(todo)));
        // Then
        result.andExpect(status().isCreated());
    }


    @Test
    public void shouldUpdateTodo() throws Exception {
        // Given
        Todo todo = new Todo(1L, "title", "desc");
        given(todoService.getTodoById(1L)).willReturn(todo);
        // When
        ResultActions result = this.mvc.perform(put("/todos/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(todo)));
        // Then
        result.andExpect(status().isNoContent());
    }
}
