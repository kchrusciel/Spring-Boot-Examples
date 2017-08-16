package pl.codecouple.todos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Krzysztof Chruściel.
 */
@Data
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

}