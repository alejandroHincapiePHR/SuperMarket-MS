package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.mappers;

import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.BillMySQLEntity;
import com.ms.supermarket.management.bill.domain.finance.Bill;

public interface BillMapper {
    Bill toDomain(BillMySQLEntity b);
    BillMySQLEntity toEntity(Bill b);
}
