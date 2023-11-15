package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.mappers;


import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.InvoiceLineItemMySQLEntity;
import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.TotalLineItemMySQLEntity;
import com.ms.supermarket.management.bill.domain.finance.InvoiceLineItem;
import com.ms.supermarket.management.bill.domain.finance.TotalLineItem;

import java.util.List;

public interface InvoiceLineItemMapper {
    InvoiceLineItem toDomain(InvoiceLineItemMySQLEntity invoiceLineItemMySQLEntity);
    InvoiceLineItemMySQLEntity toEntity(InvoiceLineItem invoiceLineItem);

    List<InvoiceLineItem> listToDomain(List<InvoiceLineItemMySQLEntity> i);

    List<InvoiceLineItemMySQLEntity> listToEntity(List<InvoiceLineItem> i);

}
