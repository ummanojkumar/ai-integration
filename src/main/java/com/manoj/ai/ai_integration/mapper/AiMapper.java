package com.manoj.ai.ai_integration.mapper;

import com.manoj.ai.ai_integration.model.GeminiRequest;
import com.manoj.ai.ai_integration.model.GeminiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AiMapper {

    public GeminiRequest mapToRequest(String query) {
        return GeminiRequest.builder()
                .contents(List.of(GeminiRequest.Content.builder()
                        .parts(List.of(GeminiRequest.Part.builder()
                                .text(query)
                                .build()))
                        .build()))
                .build();
    }

    public ResponseEntity<String> mapToResponse(ResponseEntity<GeminiResponse> geminiResponseResponseEntity) {

        return new ResponseEntity<>(
                geminiResponseResponseEntity.getBody()
                        .getCandidates()
                        .get(0)
                        .getContent()
                        .getParts()
                        .get(0)
                        .getText(), HttpStatus.OK);
    }
}
