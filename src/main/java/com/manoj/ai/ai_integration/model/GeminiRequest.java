package com.manoj.ai.ai_integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class GeminiRequest {
    private List<Content> contents;

    @AllArgsConstructor
    @Data
    @Builder
    public static class Content {
        private List<Part> parts;
    }

    @AllArgsConstructor
    @Data
    @Builder
    public static class Part {
        private String text;
    }
}
