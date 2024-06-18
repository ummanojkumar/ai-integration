package com.manoj.ai.ai_integration.service;

import com.manoj.ai.ai_integration.model.GeminiRequest;
import com.manoj.ai.ai_integration.model.GeminiResponse;
import com.manoj.ai.ai_integration.repository.GeminiAiRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AiService {
    GeminiAiRepository geminiAiRepository;

    public ResponseEntity<GeminiResponse> generateQueryResponse(GeminiRequest geminiRequest) {
        return geminiAiRepository.generateQueryResponse(geminiRequest);
    }
}
