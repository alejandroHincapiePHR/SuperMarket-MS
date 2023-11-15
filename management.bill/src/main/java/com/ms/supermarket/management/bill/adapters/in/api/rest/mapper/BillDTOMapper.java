package com.ms.supermarket.management.bill.adapters.in.api.rest.mapper;

import com.ms.supermarket.management.bill.adapters.in.api.rest.dto.BillDTO;
import com.ms.supermarket.management.bill.domain.finance.Bill;

public interface BillDTOMapper {
     BillDTO toDTO(Bill bill);

}
