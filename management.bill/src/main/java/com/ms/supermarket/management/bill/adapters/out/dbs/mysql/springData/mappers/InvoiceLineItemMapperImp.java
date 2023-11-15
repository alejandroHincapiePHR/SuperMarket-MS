package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.mappers;

import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.InvoiceLineItemMySQLEntity;
import com.ms.supermarket.management.bill.domain.finance.InvoiceLineItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceLineItemMapperImp implements InvoiceLineItemMapper {
    @Override
    public InvoiceLineItem toDomain(InvoiceLineItemMySQLEntity i) {
        InvoiceLineItem invoiceLineItem = new InvoiceLineItem(i.getProductId(), i.getQuantity(), i.getTaxes(),
                i.getDiscount(), i.getSubtotal(), i.getPoints());
        return invoiceLineItem;
    }

    @Override
    public InvoiceLineItemMySQLEntity toEntity(InvoiceLineItem i) {

        InvoiceLineItemMySQLEntity invoiceLineItemMySQLEntity = new InvoiceLineItemMySQLEntity(i.getId(), i.getProduct().getId(),
                i.getQuantity(), i.getDiscount(), i.getTaxes(), i.getSubtotal(), i.getPoints());

        return invoiceLineItemMySQLEntity;
    }

    @Override
    public List<InvoiceLineItem> listToDomain(List<InvoiceLineItemMySQLEntity> i) {
        return i.stream().map(this::toDomain).toList();
    }

    @Override
    public List<InvoiceLineItemMySQLEntity> listToEntity(List<InvoiceLineItem> i) {
        return i.stream().map(this::toEntity).toList();
    }
}
