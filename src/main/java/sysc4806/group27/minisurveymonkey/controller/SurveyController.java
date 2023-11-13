package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
            @RequestParam("question-content") List<String> questionContents) {
        surveyService.createNewSurvey(surveyTitle, questionTypes, questionContents);
        return "index";
    }

    @GetMapping("/survey/all")
    public String getAllSurveys(Model model) {
        model.addAttribute("searchValue", "All Surveys");
        model.addAttribute("surveys", surveyService.getAllSurveys());
        return "surveySearch";
    }

    @GetMapping("/survey/search")
    public String searchSurveys(@RequestBody String searchValue, Model model) {
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("surveys", surveyService.searchByName(searchValue));
        return "surveySearch";
    }

    @GetMapping("/survey/{surveyName}")
    public String showSurvey(@PathVariable("surveyName") String surveyName, Model model) {
        model.addAttribute("survey", surveyService.getSurvey(surveyName));
        return "survey";
    }

    @PostMapping("/survey/{surveyName}/submit")
    public String submitSurvey(@PathVariable("surveyName") String surveyName, @RequestParam("answers") List<String> answers, Model model) {
        surveyService.addSurveyAnswers(surveyName, answers);
        model.addAttribute("survey", surveyService.getSurvey(surveyName));
        return "submitted";
    }
}
