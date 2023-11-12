package sysc4806.group27.minisurveymonkey.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

}
