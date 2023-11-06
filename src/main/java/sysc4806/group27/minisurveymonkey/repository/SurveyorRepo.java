package sysc4806.group27.minisurveymonkey.repository;

import org.springframework.data.repository.CrudRepository;
import sysc4806.group27.minisurveymonkey.model.Surveyor;

public interface SurveyorRepo extends CrudRepository<Surveyor, Integer>  {
}
