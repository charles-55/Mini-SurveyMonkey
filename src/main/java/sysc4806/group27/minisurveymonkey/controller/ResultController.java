package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sysc4806.group27.minisurveymonkey.service.SurveyService;

@Controller
public class ResultController {

    private final SurveyService surveyService;

    public ResultController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/results/{id}")
    public String getSurveyResults(@PathVariable("id") int id, Model model){
        model.addAttribute("survey", surveyService.getSurvey(id));
        return "result";
    }
}