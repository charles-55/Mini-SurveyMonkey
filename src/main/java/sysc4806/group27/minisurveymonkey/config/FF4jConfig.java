package sysc4806.group27.minisurveymonkey.config;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4jConfig {

    @Bean
    public FF4j createFF4j() {
        // Create an instance of FF4J
        FF4j ff4j = new FF4j();

        // Create a feature and add it to FF4J
        Feature darkModeFeature = new Feature("darkMode", false, "Sets the dark mode for a page");
        ff4j.getFeatureStore().create(darkModeFeature);

        // You can add more features and configurations here programmatically

        return ff4j;
    }
}
