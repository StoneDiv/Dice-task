package com.dice.Dicetask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TConfig {

    @Value("${twitter.client-id}")
    private String clientId;

    @Value("${twitter.client-secret}")
    private String clientSecret;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(clientHttpRequestInterceptor());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestInterceptor clientHttpRequestInterceptor() {
        return (request, body, execution) -> {
            request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Basic " + base64Encode(clientId + ":" + clientSecret));
            return execution.execute(request, body);
        };
    }

    private String base64Encode(String str) {
        return java.util.Base64.getEncoder().encodeToString(str.getBytes());
    }
}
