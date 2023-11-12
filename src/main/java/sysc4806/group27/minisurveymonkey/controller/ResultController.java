package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sysc4806.group27.minisurveymonkey.model.Survey;

@Controller
public class ResultController {


    @GetMapping("/results/{name}")
    public String getSurveyResults(@PathVariable("name") String name, Model model){
        Survey survey = new Survey(); //needs to be changed to get the autowired survey
        model.addAttribute("ID", name);
        model.addAttribute("survey", survey);
        return "result";
    }
}
