package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sysc4806.group27.minisurveymonkey.model.Surveyor;

@Controller
public class ViewController {

    private Surveyor loggedInSurveyor;

    @GetMapping
    public String showHomePage() {
        return "index";
    }

}
