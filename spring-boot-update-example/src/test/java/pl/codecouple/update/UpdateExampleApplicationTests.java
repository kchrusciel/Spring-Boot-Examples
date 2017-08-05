package pl.codecouple.update;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pl.codecouple.update.todo.Todo;
import pl.codecouple.update.todo.TodoService;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class UpdateExampleApplicationTests {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TodoService todoService;


	@Test
	public void shouldPartialUpdateTodo() throws Exception {
		// Given
		todoService.addNewTodo(new Todo("title", "description"));

		HashMap<String, Object> updates = new HashMap<>();
		updates.put("title", "new title");
		updates.put("description", "new description");

		// When
		ResultActions result = this.mvc.perform(patch("/todos/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(updates)));

		Todo todoResult = todoService.getTodoById(1L);

		// Then
		result.andExpect(status().isNoContent())
				.andExpect(status().reason("Todo partial updated!"));

		assertThat(todoResult).isNotNull();
		assertThat(todoResult.getTitle()).isEqualTo("new title");
		assertThat(todoResult.getDescription()).isEqualTo("new description");
	}


}
