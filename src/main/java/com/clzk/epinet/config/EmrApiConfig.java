package com.clzk.epinet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "api")
@Data
public class EmrApiConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private String baseUrl;
}
