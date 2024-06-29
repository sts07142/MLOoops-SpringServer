package com.example.mlooops.controller;

import com.example.mlooops.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/recommend")
    public String getRecommendations(@RequestParam String userId) {
        return newsService.getRecommendations(userId);
    }

    @GetMapping("/recommend/popular")
    public String getPopularNews() {
        return newsService.getPopularNews();
    }

    @GetMapping("/recommend/demographics")
    public String getRecommendationsBasedOnDemographics(@RequestParam String gender, @RequestParam String ageGroup) {
        return newsService.getRecommendationsBasedOnDemographics(gender, ageGroup);
    }

    @GetMapping("/recommend/new-words")
    public String getRecommendationsBasedOnNewWords() {
        return newsService.getRecommendationsBasedOnNewWords();
    }

    @GetMapping("/recommend/job-seekers")
    public String getRecommendationsForJobSeekers() {
        return newsService.getRecommendationsForJobSeekers();
    }
}