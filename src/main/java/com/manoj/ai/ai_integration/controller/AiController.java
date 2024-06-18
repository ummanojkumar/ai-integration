package com.manoj.ai.ai_integration.controller;

import com.manoj.ai.ai_integration.mapper.AiMapper;
import com.manoj.ai.ai_integration.service.AiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class AiController {

    AiService aiService;
    AiMapper aiMapper;

    @GetMapping("/manojgpt/{query}")
    private String generateQueryResponse(@PathVariable("query") String query, Model model) {

        ResponseEntity<String> rawText = Optional.ofNullable(query)
                .map(aiMapper::mapToRequest)
                .map(aiService::generateQueryResponse)
                .map(aiMapper::mapToResponse)
                .orElse(null);
        model.addAttribute("rawText", rawText.getBody());
        return "beautify";
    }
}
