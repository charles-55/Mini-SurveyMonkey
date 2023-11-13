package sysc4806.group27.minisurveymonkey.repository;

import org.springframework.data.repository.CrudRepository;
import sysc4806.group27.minisurveymonkey.model.Survey;

public interface SurveyRepository extends CrudRepository<Survey, Integer> {

    Survey findById(int id);
    Survey findByName(String name);
}
