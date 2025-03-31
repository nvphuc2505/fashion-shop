package com.fashion_store.order_service.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion_store.order_service.order.domain.Order;
import com.fashion_store.order_service.order.domain.OrderService;
import com.fashion_store.order_service.order.dto.OrderRequest;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @PostMapping
    public Mono<Order> submitOrder(@Valid @RequestBody OrderRequest orderRequest) {
        
        return orderService.submitOrder(orderRequest.getProductCode(), 
                                        orderRequest.getProductQuantity());
    }

}
