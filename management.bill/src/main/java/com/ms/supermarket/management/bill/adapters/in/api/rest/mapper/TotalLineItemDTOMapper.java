package com.ms.supermarket.management.bill.adapters.in.api.rest.mapper;

import com.ms.supermarket.management.bill.adapters.in.api.rest.dto.TotalLineItemDTO;
import com.ms.supermarket.management.bill.domain.finance.TotalLineItem;

public interface TotalLineItemDTOMapper {
    TotalLineItemDTO toDTO(TotalLineItem totalLineItem);
}
