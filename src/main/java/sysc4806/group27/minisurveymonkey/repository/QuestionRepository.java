package sysc4806.group27.minisurveymonkey.repository;

import org.springframework.data.repository.CrudRepository;
import sysc4806.group27.minisurveymonkey.model.Surveyor;

/**
 * @author cadams
 */
public interface QuestionRepository extends CrudRepository<Surveyor, Long> {
}
