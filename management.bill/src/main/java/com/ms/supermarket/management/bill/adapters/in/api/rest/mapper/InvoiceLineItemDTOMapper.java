package com.ms.supermarket.management.bill.adapters.in.api.rest.mapper;

import com.ms.supermarket.management.bill.adapters.in.api.rest.dto.InvoiceLineItemDTO;
import com.ms.supermarket.management.bill.domain.finance.InvoiceLineItem;

import java.util.List;

public interface InvoiceLineItemDTOMapper {

    InvoiceLineItemDTO toDTO(InvoiceLineItem invoiceLineItem);

    List<InvoiceLineItemDTO> toDTOList (List<InvoiceLineItem> invoiceLineItemList);


}
