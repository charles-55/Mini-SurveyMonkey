package sysc4806.group27.minisurveymonkey.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class ViewController {

    @Controller
    public class viewController {
        @GetMapping("/")
        public String index(Model model) {
            return "index";
        }

        @GetMapping("/login")
        public String login(Model model) {
            return "login";
        }

        @GetMapping("/register")
        public String register(Model model){
           return "register";
        }
    }
}
