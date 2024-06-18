package com.manoj.ai.ai_integration.repository;

import com.manoj.ai.ai_integration.model.GeminiRequest;
import com.manoj.ai.ai_integration.model.GeminiResponse;
import com.manoj.ai.ai_integration.spring_adapter.AiConfig;
import com.manoj.ai.ai_integration.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Repository
@AllArgsConstructor
public class GeminiAiRepository {
    public static final String KEY = "key";
    private WebClient.Builder webClientBuilder;
    private AiConfig aiConfig;

    public ResponseEntity<GeminiResponse> generateQueryResponse(GeminiRequest geminiRequest) {

        // Set headers
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);

        // Build the URI with query parameters using UriComponentsBuilder
        String uri = UriComponentsBuilder.fromHttpUrl(aiConfig.getGeminiBaseUrl())
                .path(aiConfig.getGeminiEndpoint())
                .queryParam(KEY, aiConfig.getApiKey())
                .toUriString();

        // Create WebClient instance
        WebClient webClient = webClientBuilder.build();

        GeminiResponse geminiResponse = webClient.post()
                .uri(uri)
                .headers(headers -> headersMap.forEach(headers::set))
                .bodyValue(geminiRequest)
                .retrieve()
                .bodyToMono(GeminiResponse.class)
                .block();

        System.out.println("Gemini Response : " + geminiResponse);

        return new ResponseEntity<>(geminiResponse, HttpStatus.OK);
    }
}
