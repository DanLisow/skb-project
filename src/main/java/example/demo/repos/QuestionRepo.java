package example.demo.repos;

import example.demo.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<Question, Integer> {
}
