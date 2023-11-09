package sysc4806.group27.minisurveymonkey.repository;

import org.springframework.data.repository.CrudRepository;
import sysc4806.group27.minisurveymonkey.model.Survey;

import java.util.ArrayList;
import java.util.List;

public interface SurveyRepository extends CrudRepository<Survey, String> {

    Survey findByName(String name);
    default List<Survey> searchByName(String name) {
        List<Survey> surveys = new ArrayList<>();
        List<Survey> surveyList = (List<Survey>) findAll();

        for(Survey survey : surveyList) {
            if(survey.getName().contains(name))
                surveys.add(survey);
        }

        return surveys;
    }
}
