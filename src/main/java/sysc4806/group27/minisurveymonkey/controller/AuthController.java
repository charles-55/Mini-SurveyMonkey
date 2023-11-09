package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sysc4806.group27.minisurveymonkey.model.Surveyor;
import sysc4806.group27.minisurveymonkey.service.SurveyorService;

import java.util.List;

@Controller

public class AuthController {

    @Autowired
    private  SurveyorService service ;

    @GetMapping("/login")
    public String home(Model model){
        Surveyor surveyor = new Surveyor();
        model.addAttribute("surveyor", surveyor);
        return "login";
    }
    @GetMapping("/login/user")
    public String loggedin(@ModelAttribute("surveyor") Surveyor surveyor) {
        List<Surveyor> existingUser = service.findAllSurveyor();

        for (Surveyor s : existingUser) {
            if (s.getEmail().equals(surveyor.getEmail()) && s.getPassword().equals(surveyor.getPassword())) {
                return "index";
            }
        }
        return "index" ;
    }





    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
       Surveyor user = new Surveyor();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/save")
    public String addSurveyor( @ModelAttribute("user") Surveyor surveyor, BindingResult result
                               ){
        List<Surveyor> existingUser = service.findAllSurveyor();

        for(Surveyor s: existingUser ){
            if(s.getEmail().equals(surveyor.getEmail())){
                result.rejectValue("email", null,
                        "There is already an account registered with the same email");
            }

        }
        service.saveSurveyor(surveyor);
        return "index";
    }

}
