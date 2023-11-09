package sysc4806.group27.minisurveymonkey.service;

import org.springframework.stereotype.Service;
import sysc4806.group27.minisurveymonkey.model.Question;
import sysc4806.group27.minisurveymonkey.model.Survey;
import sysc4806.group27.minisurveymonkey.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepo;

    public SurveyService(SurveyRepository surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    public Survey createNewSurvey(List<Question> questions) {
        Survey survey = new Survey();
        surveyRepo.save(survey);

        for(Question question : questions)
            survey.addQuestion(question);

        surveyRepo.save(survey);
        return survey;
    }

    public Survey getSurvey(String surveyName) {
        Survey survey = new Survey();
        Survey survey1 = surveyRepo.findByName(surveyName);

        survey.setName(survey1.getName());
        for(Question question : survey1.getQuestions())
            survey.addQuestion(question);

        return survey;
    }

    public List<Survey> getAllSurveys() {
        List<Survey> surveys = new ArrayList<>();
        List<Survey> surveyList = (List<Survey>) surveyRepo.findAll();

        for(Survey survey : surveyList) {
            Survey newSurvey = new Survey();
            newSurvey.setName(survey.getName());
            for(Question question : survey.getQuestions())
                newSurvey.addQuestion(question);

            surveys.add(survey);
        }

        return surveys;
    }
}
