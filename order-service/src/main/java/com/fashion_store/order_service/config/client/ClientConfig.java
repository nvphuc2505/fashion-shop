package com.fashion_store.order_service.config.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

// Implementing REST clients with WebClient
@Configuration
public class ClientConfig {

    @Bean
    public WebClient webClient(ClientProperties clientProperties,
                               WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(clientProperties.getProductServiceURI().toString())
                .build();
    }

}
