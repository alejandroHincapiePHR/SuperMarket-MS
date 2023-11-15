package com.ms.supermarket.management.bill.adapters.in.ms.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProductDTO {
    private Long id;
    private String sku;
    private String productName;
    private Integer availableUnits;
    private Double price;
    private Double companyCost;
}