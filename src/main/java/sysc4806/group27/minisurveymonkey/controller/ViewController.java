package sysc4806.group27.minisurveymonkey.controller;


import org.ff4j.FF4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sysc4806.group27.minisurveymonkey.config.FF4jConfig;
import sysc4806.group27.minisurveymonkey.model.Surveyor;

import org.springframework.ui.Model;

@Controller
public class ViewController {

    private Surveyor loggedInSurveyor;
    private FF4j ff4j;

    @GetMapping("/")
    public String index(Model model) {
        if(DataTracker.loggedInSurveyorId > 0)
            model.addAttribute("loggedInState", true);
        else
            model.addAttribute("loggedInState", false);
        return "index";
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        ff4j = new FF4jConfig().createFF4j();
        if(ff4j.check("darkMode"))
            model.addAttribute("darkFeatureEnabled", true);
        else
            model.addAttribute("darkFeatureEnabled", false);
        return "settings";
    }
}
