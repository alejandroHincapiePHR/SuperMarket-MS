package com.ms.supermarket.management.bill.application.service;

import com.ms.supermarket.management.bill.application.exceptions.BillNotFoundException;
import com.ms.supermarket.management.bill.application.ports.bill.in.*;
import com.ms.supermarket.management.bill.application.ports.bill.out.BillCreatedPort;
import com.ms.supermarket.management.bill.application.ports.bill.out.GetBillByIDPort;
import com.ms.supermarket.management.bill.domain.admin.Customer;
import com.ms.supermarket.management.bill.domain.finance.Bill;
import com.ms.supermarket.management.bill.domain.finance.InvoiceLineItem;
import com.ms.supermarket.management.bill.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements BillCreationUseCase, GetBillByIDUseCase {

    private BillCreatedPort billCreatedPort;
    private GetBillByIDPort getBillByIDPort;

    @Autowired
    public BillService(final BillCreatedPort billCreatedPort,  final GetBillByIDPort getBillByIDPort) {
        this.billCreatedPort = billCreatedPort;
        this.getBillByIDPort = getBillByIDPort;
    }

    @Override
    public Bill getBillByIdUseCase(Long id) throws BillNotFoundException {
        return getBillByIDPort.getBillById(id);
    }

    @Override
    public Long billCreationUseCase(Customer customer, List<Product> products) {
        Bill bill = new Bill(customer);
        products.stream().map(x->new InvoiceLineItem(x,1)).forEach(bill::setLineItem);
        bill.confirmBillAndGetTotalLineItem(Boolean.TRUE);
        return  billCreatedPort.saveBill(bill);
    }
}
