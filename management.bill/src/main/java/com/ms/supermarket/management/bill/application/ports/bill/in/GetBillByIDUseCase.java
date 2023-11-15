package com.ms.supermarket.management.bill.application.ports.bill.in;

import com.ms.supermarket.management.bill.domain.finance.Bill;

@FunctionalInterface
public interface GetBillByIDUseCase {

    Bill getBillByIdUseCase(Long id);
}
