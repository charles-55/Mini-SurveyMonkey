package sysc4806.group27.minisurveymonkey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysc4806.group27.minisurveymonkey.model.*;
import sysc4806.group27.minisurveymonkey.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepo;

    @Autowired
    public SurveyService(SurveyRepository surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    public OpenEndedQuestion addQuestion(String surveyName, OpenEndedQuestion question) {
        Survey survey = surveyRepo.findByName(surveyName);
        survey.addQuestion(question);
        surveyRepo.save(survey);
        return question;
    }

    public void createNewSurvey(String surveyTitle,
                                List<String> questionTypes,
                                List<String> questionContents) {
        Survey survey = new Survey(surveyTitle);
        for (int i = 0; i < questionTypes.size(); i++) {
            switch (questionTypes.get(i)) {
                case "open-ended" -> {
                    OpenEndedQuestion openEndedQuestion = new OpenEndedQuestion();
                    openEndedQuestion.setSurvey(survey);
                    openEndedQuestion.setContent(questionContents.get(i));
                    survey.addQuestion(openEndedQuestion);
                    break;
                }
                case "range" -> {
                    NumberQuestion numberQuestion = new NumberQuestion();
                    numberQuestion.setSurvey(survey);
                    numberQuestion.setContent(questionContents.get(i));
                    survey.addQuestion(numberQuestion);
                }
                case "option" -> {
                    OptionQuestion optionQuestion = new OptionQuestion();
                    optionQuestion.setSurvey(survey);
                    optionQuestion.setContent(questionContents.get(i));
                    survey.addQuestion(optionQuestion);
                }
                default -> {
                    // Logic should not get hear, users can only choose from above 3 options
                }
            }
        }
        surveyRepo.save(survey);
    }

    public List<Survey> getAllSurveys() {
        List<Survey> surveys = new ArrayList<>();
        List<Survey> surveyList = (List<Survey>) surveyRepo.findAll();

        for(Survey survey : surveyList) {
            Survey newSurvey = new Survey();
            newSurvey.setName(survey.getName());
            for(Question question : survey.getQuestions())
                newSurvey.addQuestion((OpenEndedQuestion) question);
            surveys.add(survey);
        }

        return surveys;
    }

    public Survey getSurvey(String surveyName) {
        Survey survey = new Survey();
        Survey survey1 = surveyRepo.findByName(surveyName);

        survey.setName(survey1.getName());
        for(Question question : survey1.getQuestions())
            survey.addQuestion((OpenEndedQuestion) question);
        return survey;
    }

    public List<Survey> searchByName(String name) {
        List<Survey> surveys = new ArrayList<>();
        List<Survey> surveyList = (List<Survey>) surveyRepo.findAll();

        for(Survey survey : surveyList) {
            if(survey.getName().contains(name)) {
                Survey newSurvey = new Survey();
                newSurvey.setName(survey.getName());
                for(Question question : survey.getQuestions())
                    newSurvey.addQuestion((OpenEndedQuestion)question);

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
