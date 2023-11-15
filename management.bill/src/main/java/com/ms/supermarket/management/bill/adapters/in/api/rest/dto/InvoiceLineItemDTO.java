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
public class InvoiceLineItemDTO {
    private String productName;
    private Integer quantity;
    private Double subtotal;
}
