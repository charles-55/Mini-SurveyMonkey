package sysc4806.group27.minisurveymonkey.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sysc4806.group27.minisurveymonkey.model.Surveyor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sysc4806.group27.minisurveymonkey.model.Survey;

@Controller
public class ViewController {

    private Surveyor loggedInSurveyor;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/results/{id}")
    public String getSurveyResults(@PathVariable("id") Long ID, Model model){
        Survey survey = new Survey(); //needs to be changed to get the autowired survey
        model.addAttribute("ID", ID);
        model.addAttribute("survey", survey);
        return "result";
    }
}
