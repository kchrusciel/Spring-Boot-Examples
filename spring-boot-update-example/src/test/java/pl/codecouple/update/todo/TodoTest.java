package pl.codecouple.update.todo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Krzysztof Chruściel.
 */
public class TodoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenTitleIsNull() throws Exception {
        // Given
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Title cannot be null!");
        // When
        new Todo(null, "description");
    }

    @Test
    public void shouldThrowExceptionWhenTitleIsEmpty() throws Exception {
        // Given
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Title cannot be empty!");
        // When
        new Todo("", "description");
    }

    @Test
    public void shouldThrowExceptionWhenDescriptionIsNull() throws Exception {
        // Given
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Description cannot be null!");
        // When
        new Todo("title", null);
    }

    @Test
    public void shouldThrowExceptionWhenDescriptionIsEmpty() throws Exception {
        // Given
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Description cannot be empty!");
        // When
        new Todo("title", "");
    }

    @Test
    public void shouldCreateNewTodo() throws Exception {
        // When
        Todo result = new Todo("title", "description");
        // Then
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("title");
        assertThat(result.getDescription()).isEqualTo("description");
    }

    @Test
    public void shouldThrowExceptionWhenIDIsNull() throws Exception {
        // Given
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("ID cannot be null!");
        // When
        Todo result = new Todo(null, "title", "description");
    }

    @Test
    public void shouldCreteNewTodoWithID() throws Exception {
        // When
        Todo result = new Todo(1L, "title", "description");
        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("title");
        assertThat(result.getDescription()).isEqualTo("description");
    }
}
