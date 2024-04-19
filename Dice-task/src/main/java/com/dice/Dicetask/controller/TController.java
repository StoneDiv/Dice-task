package com.dice.Dicetask.controller;

import com.dice.Dicetask.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TController {

    @Autowired
    private TwitterService twitterService;

    @GetMapping("/api/search")
    public ResponseEntity<?> searchTweets(@RequestParam String query) {
        return ResponseEntity.ok(twitterService.searchTweets(query));
    }

    @GetMapping("/api/tweets/{username}")
    public ResponseEntity<?> getUserTweets(@PathVariable String username) {
        return ResponseEntity.ok(twitterService.getUserTweets(username));
    }
}
