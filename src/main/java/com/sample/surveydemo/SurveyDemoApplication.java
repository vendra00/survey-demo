package com.sample.surveydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SurveyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyDemoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {return new RestTemplate();}




}
