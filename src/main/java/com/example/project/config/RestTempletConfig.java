package com.example.project.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempletConfig {

/*
*
* */
@Bean
public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    System.out.println("Configuring RestTempletBuilder");
    return restTemplateBuilder.build();

}
}
