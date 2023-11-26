package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private SurveyorService service ;

    @GetMapping("/login")
    public String showLoginForm(Model model){
        Surveyor surveyor = new Surveyor();
        model.addAttribute("surveyor", surveyor);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model){
        model.addAttribute("loggedInState", false);
        DataTracker.loggedInSurveyorId = 0;
        return "redirect:/";
    }

    @PostMapping("/")
    public String login(@ModelAttribute("surveyor") Surveyor surveyor, Model model) {
        List<Surveyor> existingUser = service.findAllSurveyor();

        for (Surveyor s : existingUser) {
            if (s.getEmail().equals(surveyor.getEmail()) && s.getPassword().equals(surveyor.getPassword())) {
                DataTracker.loggedInSurveyorId = s.getId();
                model.addAttribute("loggedInState", true);
                return "redirect:/";
            }
        }
        return "error" ;
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
    public String addSurveyor( @ModelAttribute("user") Surveyor surveyor, BindingResult result){
        List<Surveyor> existingUser = service.findAllSurveyor();
        for(Surveyor s: existingUser ){
            if(s.getPassword().length()<7){
                result.rejectValue("password", null,
                        "password must be greater than 7");
            }
            else if(s.getPassword().equals(surveyor.getEmail())){
                result.rejectValue("email", null,
                        "password must be greater than 7");
            }

        }
        service.saveSurveyor(surveyor);
        return "redirect:/";
    }
}
