package com.ms.supermarket.management.bill.adapters.in.api.rest.mapper;

import com.ms.supermarket.management.bill.adapters.in.api.rest.dto.BillDTO;
import com.ms.supermarket.management.bill.adapters.in.api.rest.dto.InvoiceLineItemDTO;
import com.ms.supermarket.management.bill.adapters.in.api.rest.dto.TotalLineItemDTO;
import com.ms.supermarket.management.bill.application.service.CustomerService;
import com.ms.supermarket.management.bill.domain.admin.Customer;
import com.ms.supermarket.management.bill.domain.finance.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillDTOMapperImp implements BillDTOMapper {

    private CustomerService customerService;
    private InvoiceLineItemDTOMapper invoiceLineItemDTOMapper;
    private TotalLineItemDTOMapper totalLineItemDTOMapper;

    @Autowired
    public BillDTOMapperImp(CustomerService customerService, InvoiceLineItemDTOMapper invoiceLineItemDTOMapper,
                            TotalLineItemDTOMapper totalLineItemDTOMapper) {
        this.customerService = customerService;
        this.invoiceLineItemDTOMapper = invoiceLineItemDTOMapper;
        this.totalLineItemDTOMapper = totalLineItemDTOMapper;
    }

    @Override
    public BillDTO toDTO(Bill b) {

       Customer customer = customerService.customerById(b.getCustomer().getId());
       List<InvoiceLineItemDTO> invoiceLineItemDTOList = invoiceLineItemDTOMapper.toDTOList(b.getLineItems());
        TotalLineItemDTO totalLineItemDTO = totalLineItemDTOMapper.toDTO(b.getTotalLineItem());

        BillDTO billDTO = BillDTO.builder()
                .customerName(customer.getFirstName())
                .customerLastName(customer.getLastName())
                .billId(b.getId())
                .issueDate(b.getIssueDate())
                .invoiceLineItemDTOList(invoiceLineItemDTOList)
                .totalLineItemDTO(totalLineItemDTO)
                .build();
        return billDTO;
    }
}
