package com.ms.supermarket.management.bill.adapters.in.api.rest.dto;

import com.ms.supermarket.management.bill.adapters.in.ms.customer.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {
    private String customerName;
    private String customerLastName;
    private Long billId;
    private Date issueDate;
    private List<InvoiceLineItemDTO> invoiceLineItemDTOList;
    private TotalLineItemDTO totalLineItemDTO;
}
