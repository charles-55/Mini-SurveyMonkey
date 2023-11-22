package sysc4806.group27.minisurveymonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sysc4806.group27.minisurveymonkey.model.Surveyor;

import org.springframework.ui.Model;
import sysc4806.group27.minisurveymonkey.service.FeatureToggleService;

@Controller
public class ViewController {

    private final FeatureToggleService featureToggleService;
    private Surveyor loggedInSurveyor;

    public ViewController(FeatureToggleService featureToggleService) {
        this.featureToggleService = featureToggleService;
    }

    @GetMapping("/")
    public String index(Model model) {
        System.out.println(featureToggleService.isDarkModeEnabled());
        model.addAttribute("darkModeEnabled", featureToggleService.isDarkModeEnabled());
        return "index2";
    }

}
