package com.dice.Dicetask.service;

import org.springframework.http.HttpHeaders;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TService {

    @Value("${twitter.api.base-url}")
    private String twitterApiBaseUrl;

    public ResponseEntity<?> searchUser(String username, String clientId, String clientSecret) {
        String apiUrl = twitterApiBaseUrl + "/users/search?username=" + username;
        return callTwitterApi(apiUrl, clientId, clientSecret);
    }
    
    public ResponseEntity<?> getTweets(String userId, String clientId, String clientSecret) {
        String apiUrl = twitterApiBaseUrl + "/users/" + userId + "/tweets";
        return callTwitterApi(apiUrl, clientId, clientSecret);
    }
    

    private ResponseEntity<?> callTwitterApi(String apiUrl, String clientId, String clientSecret) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + getAccessToken(clientId, clientSecret));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
    }

    private String getAccessToken(String clientId, String clientSecret) {
        return "ACCESS_TOKEN";
    }
}

