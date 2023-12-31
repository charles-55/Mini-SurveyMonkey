package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sysc4806.group27.minisurveymonkey.model.*;
import sysc4806.group27.minisurveymonkey.service.SurveyService;

import java.util.List;

@Controller
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/survey/add")
    public String createSurvey() {
        return "createSurvey";
    }

    @PostMapping("/survey/add")
    public String addSurvey(
            @RequestParam("survey-title") String surveyTitle,
            @RequestParam("question-type") List<String> questionTypes,
            @RequestParam("question-content") List<String> questionContents,
            @RequestParam("range-min") List<Integer> rangeQuestionMins,
            @RequestParam("range-max") List<Integer> rangeQuestionMaxs,
            @RequestParam("range-step") List<Integer> rangeQuestionSteps,
            @RequestParam("mchoice-options") List<String> optionQuestionOptions) {
        surveyService.createNewSurvey(DataTracker.loggedInSurveyorId, surveyTitle, questionTypes, questionContents,
                rangeQuestionMins, rangeQuestionMaxs, rangeQuestionSteps, optionQuestionOptions);
        return "createSuccess";
    }

    @GetMapping("/survey/all")
    public String getAllSurveys(Model model) {
        model.addAttribute("searchValue", "All Surveys");
        model.addAttribute("surveys", surveyService.getAllSurveys());
        return "surveySearch";
    }

    @GetMapping("/survey/search")
    public String searchSurveys(@RequestParam("searchInput") String searchValue, Model model) {
        model.addAttribute("searchValue", "Search results for " + searchValue + ":");
        model.addAttribute("surveys", surveyService.searchByName(searchValue));
        return "surveySearch";
    }

    @GetMapping("/survey/{surveyId}")
    public String showSurvey(@PathVariable("surveyId") int surveyId, Model model) {
        Survey survey = surveyService.getSurvey(surveyId);
        model.addAttribute("survey", survey);
        model.addAttribute("questions", survey.getQuestions());
        return "survey";
    }

    @PostMapping("/survey/{surveyId}/submit")
    public String submitSurvey(@PathVariable("surveyId") int surveyId, @RequestParam("answers") List<String> answers,  Model model) {
        surveyService.addSurveyAnswers(surveyId, answers);
        model.addAttribute("survey", surveyService.getSurvey(surveyId));
        return "submitted";
    }

    @PostMapping("/survey/toggleAccess")
    public String toggleAccess(@RequestParam int surveyId) {
        surveyService.toggleSurveyAccess(surveyId);
        return "redirect:/account";
    }
}
