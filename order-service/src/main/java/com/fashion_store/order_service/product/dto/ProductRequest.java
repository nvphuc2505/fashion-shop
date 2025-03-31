package com.fashion_store.order_service.product.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductRequest {

    private String productCode;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;

}
