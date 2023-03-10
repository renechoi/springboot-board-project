package kosta.springjspblog.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {

        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/403");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/403");
        ErrorPage errorPageEx = new ErrorPage(RuntimeException.class, "/WEB-INF/views/error/403.jsp");
        ErrorPage errorPageEX2 = new ErrorPage(IllegalArgumentException.class, "/error/403");

        factory.addErrorPages(errorPage404, errorPage500, errorPageEx,errorPageEX2);

    }
}
