package pl.codecouple.update.todo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Krzysztof Chruściel.
 */
@Data
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    public Todo(String title, String description) {
        Assert.notNull(title, "Title cannot be null!");
        Assert.hasLength(title, "Title cannot be empty!");
        Assert.notNull(description, "Description cannot be null!");
        Assert.hasLength(description, "Description cannot be empty!");
        this.title = title;
        this.description = description;
    }


    public Todo(Long id, String title, String description) {
        Assert.notNull(title, "Title cannot be null!");
        Assert.hasLength(title, "Title cannot be empty!");
        Assert.notNull(description, "Description cannot be null!");
        Assert.hasLength(description, "Description cannot be empty!");
        Assert.notNull(id, "ID cannot be null!");
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
