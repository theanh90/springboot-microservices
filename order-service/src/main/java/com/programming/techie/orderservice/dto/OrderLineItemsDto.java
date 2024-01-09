package com.programming.techie.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderLineItemsDto {
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
