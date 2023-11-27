package sysc4806.group27.minisurveymonkey.config;

import org.ff4j.FF4j;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// The class should be on classpath : FF4jDispatcherServlet
@ConditionalOnClass({FF4jDispatcherServlet.class})
// Setup FF4j first, not is required
@AutoConfigureAfter(FF4jConfig.class)
public class FF4jWebConsoleConfig extends SpringBootServletInitializer {
    // Define FF4jDispatcherServlet bean
    @Bean
    @ConditionalOnMissingBean
    public FF4jDispatcherServlet defineFF4jServlet(FF4j ff4j) {
        FF4jDispatcherServlet ff4jConsoleServlet = new FF4jDispatcherServlet();
        ff4jConsoleServlet.setFf4j(ff4j);
        return ff4jConsoleServlet;
    }

    // Register FF4jDispatcherServlet with a URL pattern
    @Bean
    public ServletRegistrationBean<FF4jDispatcherServlet> registerFF4jServlet(
            FF4jDispatcherServlet ff4jDispatcherServlet) {
        return new ServletRegistrationBean<>(ff4jDispatcherServlet, "/ff4j-web-console/*");
    }

}