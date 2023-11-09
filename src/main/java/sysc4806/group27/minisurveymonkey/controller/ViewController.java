package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sysc4806.group27.minisurveymonkey.model.Surveyor;
import sysc4806.group27.minisurveymonkey.service.SurveyService;

@Controller
public class ViewController {

    private Surveyor loggedInSurveyor;
    private final SurveyService surveyService;

    public ViewController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/survey/{surveyName}")
    public String showSurvey(@PathVariable("surveyName") String surveyName, Model model) {
        model.addAttribute("survey", surveyService.getSurvey(surveyName));
        return "survey";
    }

    @GetMapping("/survey/add")
    public String createSurvey() {
        return "createSurvey";
    }

    @GetMapping
    public String showResult() {
        // get survey to display result
        // iterate through each question
        // check the type of question (instanceOf)
        // type cast the actual type to the result
        // add result to the model
        return "result";
    }
}
