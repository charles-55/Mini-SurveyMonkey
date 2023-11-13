package sysc4806.group27.minisurveymonkey.service;

import org.springframework.stereotype.Service;
import sysc4806.group27.minisurveymonkey.model.Question;
import sysc4806.group27.minisurveymonkey.model.Survey;
import sysc4806.group27.minisurveymonkey.model.TextQuestion;
import sysc4806.group27.minisurveymonkey.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepo;

    public SurveyService(SurveyRepository surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    public TextQuestion addQuestion(String surveyName, TextQuestion question) {
        Survey survey = surveyRepo.findByName(surveyName);
        survey.addQuestion(question);
        surveyRepo.save(survey);
        return question;
    }

    public Survey createNewSurvey(String surveyName) {
        Survey survey = new Survey();
        survey.setName(surveyName);
        surveyRepo.save(survey);
        return survey;
    }

    public List<Survey> getAllSurveys() {
        List<Survey> surveys = new ArrayList<>();
        List<Survey> surveyList = (List<Survey>) surveyRepo.findAll();

        for(Survey survey : surveyList) {
            Survey newSurvey = new Survey();
            newSurvey.setName(survey.getName());
            for(TextQuestion question : survey.getQuestions())
                newSurvey.addQuestion(question);

            surveys.add(survey);
        }

        return surveys;
    }

    public Survey getSurvey(String surveyName) {
        Survey survey = new Survey();
        Survey survey1 = surveyRepo.findByName(surveyName);

        survey.setName(survey1.getName());
        for(TextQuestion question : survey1.getQuestions())
            survey.addQuestion(question);

        return survey;
    }

    public List<Survey> searchByName(String name) {
        List<Survey> surveys = new ArrayList<>();
        List<Survey> surveyList = (List<Survey>) surveyRepo.findAll();

        for(Survey survey : surveyList) {
            if(survey.getName().contains(name)) {
                Survey newSurvey = new Survey();
                newSurvey.setName(survey.getName());
                for(TextQuestion question : survey.getQuestions())
                    newSurvey.addQuestion(question);

                surveys.add(newSurvey);
            }
        }

        return surveys;
    }

    public void addSurveyAnswers(String surveyName, List<String> answers) {
        Survey survey = surveyRepo.findByName(surveyName);

        for(int i = 0; i < survey.getQuestions().size(); i++) {
            survey.getQuestions().get(i).addAnswer(answers.get(i));
        }
    }
}
