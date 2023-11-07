package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AuthController {
    @GetMapping("/login")
    public String home(){
        return "login";
    }

    @GetMapping("/register")
    public String home2(){
        return "register";
    }

}
