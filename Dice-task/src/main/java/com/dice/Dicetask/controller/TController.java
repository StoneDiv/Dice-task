package com.dice.Dicetask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.dice.Dicetask.service.TService;

@RestController
public class TController {

    @Autowired
    private TService tService;

    @GetMapping("/search-user/{username}")
    public ResponseEntity<?> searchUser(
            @PathVariable String username,
            @RequestHeader("client-id") String clientId,
            @RequestHeader("client-secret") String clientSecret
    ) {
        return tService.searchUser(username, clientId, clientSecret);
    }

    @GetMapping("/get-tweets/{userId}")
    public ResponseEntity<?> getTweets(
            @PathVariable String userId,
            @RequestHeader("client-id") String clientId,
            @RequestHeader("client-secret") String clientSecret
    ) {
        return tService.getTweets(userId, clientId, clientSecret);
    }
}

