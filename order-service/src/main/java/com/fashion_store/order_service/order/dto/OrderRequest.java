package com.fashion_store.order_service.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OrderRequest {
    
    @NotBlank(message = "The product code must be defined.")
    private String productCode;

    @NotNull(message = "The product quantity must be defined.")
    @Min(value = 1, message = "The value of product quantity must be greater than 0.")
    private Integer productQuantity;

}
