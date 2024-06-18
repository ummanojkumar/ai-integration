package com.manoj.ai.ai_integration.spring_adapter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ai")
@Getter
@Setter
public class AiConfig {
    private String geminiBaseUrl;
    private String geminiEndpoint;
    private String apiKey;
}
