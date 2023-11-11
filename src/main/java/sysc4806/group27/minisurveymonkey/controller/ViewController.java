package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sysc4806.group27.minisurveymonkey.model.Survey;

public class ViewController {

    @GetMapping("/results/{id}")
    public String getSurveyResults(@PathVariable("id") Long ID, Model model){
        Survey survey = new Survey(); //needs to be changed to get the autowired survey
        model.addAttribute("ID", ID);
        model.addAttribute("survey", survey);
        return "result";
    }
}
