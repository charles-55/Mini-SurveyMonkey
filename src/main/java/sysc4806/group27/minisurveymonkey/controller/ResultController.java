package sysc4806.group27.minisurveymonkey.controller;

import org.ff4j.FF4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sysc4806.group27.minisurveymonkey.config.FF4jConfig;
import sysc4806.group27.minisurveymonkey.service.SurveyService;

@Controller
public class ResultController {

    private final SurveyService surveyService;
    private FF4j ff4j;

    public ResultController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/results/{id}")
    public String getSurveyResults(@PathVariable("id") int id, Model model) {
        model.addAttribute("survey", surveyService.getSurvey(id));

        ff4j = new FF4jConfig().createFF4j();
        if(ff4j.check("darkMode")){
            System.out.println("DarkMode Activated");
        }
        return "result";
    }

//    @GetMapping("/results/{id}")
//    public String getSurveyResults(@PathVariable("id") int id, Model model) {
//        model.addAttribute("survey", surveyService.getSurvey(id));
//        model.addAttribute("optionsAndAnswerCounts", surveyService.getOptionsAndAnswerCounts(id));
//        return "result";
//    }
}