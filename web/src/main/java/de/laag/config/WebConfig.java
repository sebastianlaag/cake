package de.laag.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import de.laag.Constants;

@SpringBootApplication
@ComponentScan(basePackages = Constants.BASE_PACKAGE)
@Import({BusinessConfig.class, DatabaseConfig.class})
public class WebConfig {

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

}
