package com.fashion_store.order_service.order.domain;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    private String productCode;
    private String productName;
    private Integer productQuantity;
    private BigDecimal productPrice;

    private OrderStatus orderStatus;

    @CreatedDate
    private Instant createdDate;
    
    @LastModifiedDate
    private Instant lastModifiedDate;
 
    @Version
    private int version;

}
