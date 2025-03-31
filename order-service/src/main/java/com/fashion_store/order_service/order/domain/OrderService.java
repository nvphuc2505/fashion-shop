package com.fashion_store.order_service.order.domain;

import com.fashion_store.order_service.product.ProductClient;
import com.fashion_store.order_service.product.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public Flux<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    /*
    public Mono<Order> submitOrder(String productCode, int quantity) {
        return Mono.just(buildRejectedOrder(productCode, quantity))
                .flatMap(orderRepository::save);
    }
     */

    public Mono<Order> submitOrder(String productCode, int quantity) {
        return productClient.getProductByProductCode(productCode)
                .map(
                    productRequest ->
                        buildAcceptedOrder(productRequest, quantity)
                )
                .defaultIfEmpty(buildRejectedOrder(productCode, quantity))
                .flatMap(orderRepository::save);
    }

    private static Order buildRejectedOrder(String productCode, int quantity) {
        return Order.builder()
                .productCode(productCode)
                .productName(null)
                .productPrice(null)
                .productQuantity(quantity)
                .orderStatus(OrderStatus.REJECTED)
                .build();
    }

    private static Order buildAcceptedOrder(ProductRequest productRequest, int quantity) {
        return Order.builder()
                .productCode(productRequest.getProductCode())
                .productName(productRequest.getProductName())
                .productQuantity(quantity)
                .productPrice(productRequest.getProductPrice())
                .orderStatus(OrderStatus.ACCEPTED)
                .build();
    }
}
