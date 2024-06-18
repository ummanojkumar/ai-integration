package com.manoj.ai.ai_integration.controller;

import com.manoj.ai.ai_integration.mapper.AiMapper;
import com.manoj.ai.ai_integration.service.AiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class AiController {

    AiService aiService;
    AiMapper aiMapper;

    @GetMapping("/manojgpt/{query}")
    private ResponseEntity<String> generateQueryResponse(@PathVariable("query") String query) {

        return Optional.ofNullable(query)
                .map(aiMapper::mapToRequest)
                .map(aiService::generateQueryResponse)
                .map(aiMapper::mapToResponse)
                .orElse(null);
    }
}
