package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.mappers;

import com.ms.supermarket.management.bill.adapters.in.api.rest.dto.TotalLineItemDTO;
import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.TotalLineItemMySQLEntity;
import com.ms.supermarket.management.bill.domain.finance.TotalLineItem;


public interface TotalLineItemMapper {

    TotalLineItem toDomain(TotalLineItemMySQLEntity totalLineItemMySQLEntity);

    TotalLineItemMySQLEntity toEntity(TotalLineItem totalLineItem);


}
