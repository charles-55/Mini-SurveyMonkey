package sysc4806.group27.minisurveymonkey.repository;

import org.springframework.data.repository.CrudRepository;
import sysc4806.group27.minisurveymonkey.model.Question;

/**
 * @author cadams
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
