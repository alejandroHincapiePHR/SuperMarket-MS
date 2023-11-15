package com.ms.supermarket.management.bill.adapters.in.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TotalLineItemDTO {
    private Integer totalQuantityProducts;
    private Double totalTaxes;
    private Double totalToPay;
    private Double totalAccumulatedPoints;
}
