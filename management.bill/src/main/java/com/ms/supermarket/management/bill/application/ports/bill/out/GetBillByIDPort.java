package com.ms.supermarket.management.bill.application.ports.bill.out;

import com.ms.supermarket.management.bill.domain.finance.Bill;

@FunctionalInterface
public interface GetBillByIDPort {

    Bill getBillById(Long id);
}
