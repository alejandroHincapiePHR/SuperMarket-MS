package com.ms.supermarket.management.bill.adapters.in.api.rest.mapper;

import com.ms.supermarket.management.bill.adapters.in.api.rest.dto.TotalLineItemDTO;
import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.mappers.TotalLineItemMapper;
import com.ms.supermarket.management.bill.domain.finance.TotalLineItem;
import org.springframework.stereotype.Component;

@Component
public class TotalLineItemDTOMapperImp implements TotalLineItemDTOMapper {
    @Override
    public TotalLineItemDTO toDTO(TotalLineItem t) {
        TotalLineItemDTO totalLineItemDTO = TotalLineItemDTO.builder()
                .totalQuantityProducts(t.getTotalQuantityProducts())
                .totalTaxes(t.getTotalTaxes())
                .totalToPay(t.getTotalToPay())
                .totalAccumulatedPoints(t.getTotalAccumulatedPoints())
                .build();
        return totalLineItemDTO;
    }
}
