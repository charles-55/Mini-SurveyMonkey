package sysc4806.group27.minisurveymonkey.service;

import org.springframework.stereotype.Service;
import sysc4806.group27.minisurveymonkey.model.*;
import sysc4806.group27.minisurveymonkey.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepo;

    private final SurveyorService surveyorService;

    public SurveyService(SurveyRepository surveyRepo, SurveyorService surveyorService) {
        this.surveyRepo = surveyRepo;
        this.surveyorService = surveyorService;
    }

    public OpenEndedQuestion addQuestion(String surveyName, OpenEndedQuestion question) {
        Survey survey = surveyRepo.findByName(surveyName);
        survey.addQuestion(question);
        surveyRepo.save(survey);
        return question;
    }

    public void createNewSurvey(long surveyorId, String surveyTitle,
                                List<String> questionTypes, List<String> questionContents,
                                List<Integer> rangeQuestionMins, List<Integer> rangeQuestionMaxs, List<Integer> rangeQuestionSteps,
                                List<String> optionQuestionOptions) {
        Survey survey = new Survey(surveyTitle);
        surveyRepo.save(survey);
        for (int i = 0; i < questionTypes.size(); i++) {
            switch (questionTypes.get(i)) {
                case "open-ended" -> {
                    OpenEndedQuestion openEndedQuestion = new OpenEndedQuestion();
                    openEndedQuestion.setSurvey(survey);
                    openEndedQuestion.setContent(questionContents.get(i));
                    survey.addQuestion(openEndedQuestion);
                }
                case "range" -> {
                    NumberQuestion numberQuestion = new NumberQuestion(
                            rangeQuestionMins.get(i),
                            rangeQuestionMaxs.get(i),
                            rangeQuestionSteps.get(i));
                    numberQuestion.setSurvey(survey);
                    numberQuestion.setContent(questionContents.get(i));
                    survey.addQuestion(numberQuestion);
                }
                case "option" -> {
                    OptionQuestion optionQuestion = new OptionQuestion();
                    String optionsStr = optionQuestionOptions.get(i);
                    String[] options = optionsStr.split("\\|");
                    for (String option: options) {
                        optionQuestion.addOption(option);
                    }
                    optionQuestion.setSurvey(survey);
                    optionQuestion.setContent(questionContents.get(i));
                    survey.addQuestion(optionQuestion);
                }
                default -> {
                    // Logic should not get here, users can only choose from above 3 options
                }
            }
        }

        surveyorService.addSurvey(surveyorId, survey);
        surveyRepo.save(survey);
    }

    public List<Survey> getAllSurveys() {
        List<Survey> surveys = new ArrayList<>();
        List<Survey> surveyList = (List<Survey>) surveyRepo.findAll();

        return createSurveyCopyList(surveys, surveyList);
    }

    private List<Survey> createSurveyCopyList(List<Survey> surveys, List<Survey> surveyList) {
        for(Survey survey : surveyList) {
            Survey newSurvey = new Survey();
            newSurvey.setName(survey.getName());
            for(Question question : survey.getQuestions())
                newSurvey.addQuestion(question);

            surveys.add(survey);
        }

        return surveys;
    }

    public Survey getSurvey(int id) {
        Survey survey = new Survey();
        Survey survey1 = surveyRepo.findById(id);

        survey.setId(id);
        survey.setName(survey1.getName());
        for(Question question : survey1.getQuestions())
            survey.addQuestion(question);
        return survey;
    }

    public List<Survey> searchByAvailability(boolean isLocked) {
        List<Survey> surveys = new ArrayList<>();
        List<Survey> surveyList = (List<Survey>) surveyRepo.findByLocked(isLocked);

        return createSurveyCopyList(surveys, surveyList);
    }

    public List<Survey> searchByName(String name) {
        List<Survey> surveys = new ArrayList<>();
        List<Survey> surveyList = (List<Survey>) surveyRepo.findAll();

        for(Survey survey : surveyList) {
            if(survey.getName().contains(name)) {
                Survey newSurvey = new Survey();
                newSurvey.setName(survey.getName());
                for(Question question : survey.getQuestions())
                    newSurvey.addQuestion(question);

                surveys.add(newSurvey);
            }
        }

        return surveys;
    }

    public void addSurveyAnswers(int id, List<String> answers) {
        Survey survey = surveyRepo.findById(id);

        for(int i = 0; i < survey.getQuestions().size(); i++)
            survey.getQuestions().get(i).addAnswer(answers.get(i));

        surveyRepo.save(survey);
    }

    //New stuff
    public Map<String, List<Long>> getOptionsAndAnswerCounts(int id) {
        Survey survey = surveyRepo.findById(id);

        Map<String, List<Long>> optionsAndCounts = new HashMap<>();
        for (Question question : survey.getQuestions()) {
            if (question instanceof OptionQuestion) {
                OptionQuestion optionQuestion = (OptionQuestion) question;
                List<String> options = optionQuestion.getOptions();
                List<Long> counts = new ArrayList<>();
                for (String option : options) {
                    long count = optionQuestion.getAnswers().stream().filter(answer -> answer.equals(option)).count();
                    counts.add(count);
                }
                optionsAndCounts.put(question.getId().toString(), counts);
            }
        }
        return optionsAndCounts;
    }
}
