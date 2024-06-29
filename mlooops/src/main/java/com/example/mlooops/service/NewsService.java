package com.example.mlooops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NewsService {
    @Autowired
    private WebClient webClient;

    public String getRecommendations(String userId) {
        return webClient.get()
                .uri("/recommend?user_id=" + userId)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getPopularNews() {
        return webClient.get()
                .uri("/recommend/popular")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getRecommendationsBasedOnDemographics(String gender, String ageGroup) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/recommend/demographics")
                        .queryParam("gender", gender)
                        .queryParam("age_group", ageGroup)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getRecommendationsBasedOnNewWords() {
        return webClient.get()
                .uri("/recommend/new-words")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getRecommendationsForJobSeekers() {
        return webClient.get()
                .uri("/recommend/job-seekers")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}