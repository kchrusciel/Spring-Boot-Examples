package pl.codecouple.update.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Krzysztof Chruściel.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
}
