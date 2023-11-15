package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.repository;
import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.*;
import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.repository.base.*;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalLineItemMySQLRepository extends GenericMySQLRepository<TotalLineItemMySQLEntity, Long> {
}
