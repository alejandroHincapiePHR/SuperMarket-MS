package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.mappers;

import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.BillMySQLEntity;
import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.InvoiceLineItemMySQLEntity;
import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.TotalLineItemMySQLEntity;
import com.ms.supermarket.management.bill.domain.admin.Customer;
import com.ms.supermarket.management.bill.domain.finance.Bill;
import com.ms.supermarket.management.bill.domain.finance.InvoiceLineItem;
import com.ms.supermarket.management.bill.domain.finance.TotalLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillMapperImp implements BillMapper {

    private InvoiceLineItemMapper invoiceLineItemMapper;
    private TotalLineItemMapper totalLineItemMapper;

    @Autowired
    public BillMapperImp(InvoiceLineItemMapper invoiceLineItemMapper, TotalLineItemMapper totalLineItemMapper) {
        this.invoiceLineItemMapper = invoiceLineItemMapper;
        this.totalLineItemMapper = totalLineItemMapper;
    }


    @Override
    public Bill toDomain(BillMySQLEntity b) {
        Customer customer = new Customer(b.getCustomerId());

        List<InvoiceLineItem> invoiceLineItemList = invoiceLineItemMapper.listToDomain(b.getLineItems());
        TotalLineItem totalLineItem = totalLineItemMapper.toDomain(b.getTotalLineItem());

        Bill bill = new Bill(b.getBillId(), customer, b.getIssueDate(), invoiceLineItemList,totalLineItem);

        return bill;
    }

    @Override
    public BillMySQLEntity toEntity(Bill b) {

        List<InvoiceLineItemMySQLEntity> invoiceLineItemMySQLEntityList =invoiceLineItemMapper.listToEntity(b.getLineItems());
        TotalLineItemMySQLEntity totalLineItemMySQLEntity = totalLineItemMapper.toEntity(b.getTotalLineItem());

        BillMySQLEntity billMySQLEntity = new BillMySQLEntity(b.getId(), b.getIssueDate(),
                b.getCustomer().getId(),totalLineItemMySQLEntity,invoiceLineItemMySQLEntityList);



        return billMySQLEntity;
    }
}
