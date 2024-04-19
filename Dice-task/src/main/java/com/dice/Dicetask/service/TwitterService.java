package com.dice.Dicetask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwitterService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${twitter.api.base-url}")
    private String baseUrl;

    public ResponseEntity<?> searchTweets(String query) {
        String searchUrl = baseUrl + "/2/tweets/search/recent?query=" + query;
        return restTemplate.getForEntity(searchUrl, Object.class);
    }

    public ResponseEntity<?> getUserTweets(String username) {
        String userTweetsUrl = baseUrl + "/2/users/by/username/" + username + "/tweets";
        return restTemplate.getForEntity(userTweetsUrl, Object.class);
    }
}
