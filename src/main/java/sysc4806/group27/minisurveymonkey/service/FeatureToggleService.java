package sysc4806.group27.minisurveymonkey.service;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysc4806.group27.minisurveymonkey.config.FF4jConfig;

@Service
public class FeatureToggleService {

    @Autowired
    private FF4j ff4j;

    public boolean isDarkModeEnabled() {
        return ff4j.check(FF4jConfig.DARK_MODE);
    }
}
