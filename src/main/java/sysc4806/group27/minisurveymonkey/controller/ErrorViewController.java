package sysc4806.group27.minisurveymonkey.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorViewController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (statusCode != null) {
            int code = Integer.parseInt(statusCode.toString());
            model.addAttribute("errorCode", code);

            for(HttpStatus status : HttpStatus.values()) {
                if(code == status.value()) {
                    model.addAttribute("description", status.getReasonPhrase());
                    break;
                }
            }
        }
        else
            model.addAttribute("errorCode", "Unknown");
        return "error";
    }
}
