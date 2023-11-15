package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.mappers;

import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.TotalLineItemMySQLEntity;
import com.ms.supermarket.management.bill.domain.finance.TotalLineItem;
import org.springframework.stereotype.Component;

@Component
public class TotalLineItemMapperImp implements  TotalLineItemMapper{
    @Override
    public TotalLineItem toDomain(TotalLineItemMySQLEntity t) {

        TotalLineItem totalLineItem = new TotalLineItem();

        totalLineItem.setId(t.getTotalLineItemId());
        totalLineItem.setTotalQuantityProducts(t.getTotalQuantityProducts());
        totalLineItem.setTotalTaxes(t.getTotalTaxes());
        totalLineItem.setTotalToPay(t.getTotalToPay());
        totalLineItem.setTotalAccumulatedPoints(t.getTotalAccumulatedPoints());
        return totalLineItem;
    }

    @Override
    public TotalLineItemMySQLEntity toEntity(TotalLineItem t) {

        TotalLineItemMySQLEntity totalLineItemMySQLEntity = new TotalLineItemMySQLEntity();

        totalLineItemMySQLEntity.setTotalLineItemId(t.getId());
        totalLineItemMySQLEntity.setTotalQuantityProducts(t.getTotalQuantityProducts());
        totalLineItemMySQLEntity.setTotalTaxes(t.getTotalTaxes());
        totalLineItemMySQLEntity.setTotalToPay(t.getTotalToPay());
        totalLineItemMySQLEntity.setTotalAccumulatedPoints(t.getTotalAccumulatedPoints());

        return totalLineItemMySQLEntity;
    }
}
