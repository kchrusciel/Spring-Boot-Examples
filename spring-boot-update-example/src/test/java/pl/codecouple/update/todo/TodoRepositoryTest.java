package pl.codecouple.update.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Krzysztof Chruściel.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void shouldSaveTodo() throws Exception {
        // Given
        Todo todo = new Todo(1L, "title", "description");
        // When
        todoRepository.save(todo);
        Long result = testEntityManager.getId(todo, Long.class);
        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(1L);
    }

    @Test
    public void shouldFindTodoByID() throws Exception {
        // Given
        Todo todo = new Todo("title", "description");
        testEntityManager.persist(todo);
        // When
        Todo result = todoRepository.findOne(1L);
        // Then
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("title");
        assertThat(result.getDescription()).isEqualTo("description");
    }
}
