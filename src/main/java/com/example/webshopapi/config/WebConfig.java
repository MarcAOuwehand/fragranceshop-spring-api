    package com.example.webshopapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    public class WebConfig implements WebMvcConfigurer {


        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:4200", "https://seashell-app-xnfcn.ondigitalocean.app", "https://s1142622-iprwc.store:8081", "https://178.62.238.163:8081") // Hier kun je meerdere origins toevoegen als nodig.
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // Als voorbeeld
                    .allowCredentials(true);
        }

    }
