package sysc4806.group27.minisurveymonkey.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sysc4806.group27.minisurveymonkey.model.Surveyor;

import org.springframework.ui.Model;

@Controller
public class ViewController {

    private Surveyor loggedInSurveyor;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

}
