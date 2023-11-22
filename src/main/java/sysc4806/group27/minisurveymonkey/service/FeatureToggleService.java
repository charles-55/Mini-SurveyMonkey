package sysc4806.group27.minisurveymonkey.service;

import org.ff4j.FF4j;
import org.springframework.stereotype.Service;
import sysc4806.group27.minisurveymonkey.config.FF4jConfig;

@Service
public class FeatureToggleService {
    private FF4j ff4j;

    public boolean isDarkModeEnabled() {
        ff4j = new FF4jConfig().createFF4j();
        return ff4j.check("darkMode");
    }
}
