package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sysc4806.group27.minisurveymonkey.service.SurveyService;

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

    @GetMapping("/survey/{surveyName}")
    public String showSurvey(@PathVariable("surveyName") String surveyName, Model model) {
        model.addAttribute("survey", surveyService.getSurvey(surveyName));
        return "survey";
    }

    @PostMapping("/survey/{surveyName}/submit")
    public String submitSurvey(@PathVariable("surveyName") String surveyName, Model model) {
        model.addAttribute("survey", surveyService.getSurvey(surveyName));
        return "survey";
    }
}
