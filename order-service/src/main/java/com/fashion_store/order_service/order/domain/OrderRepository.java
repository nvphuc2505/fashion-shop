package com.fashion_store.order_service.order.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository 
    extends ReactiveCrudRepository<Order, Long> {
    
}
