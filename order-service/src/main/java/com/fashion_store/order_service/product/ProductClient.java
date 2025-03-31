package com.fashion_store.order_service.product;

import com.fashion_store.order_service.product.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ProductClient {

    private static final String PRODUCT_ROOT_API = "/products/";
    private final WebClient webClient;

    @Autowired
    public ProductClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ProductRequest> getProductByProductCode(String productCode) {

        return webClient
                .get()
                .uri(PRODUCT_ROOT_API + productCode)
                .retrieve()
                .bodyToMono(ProductRequest.class);
    }
}
