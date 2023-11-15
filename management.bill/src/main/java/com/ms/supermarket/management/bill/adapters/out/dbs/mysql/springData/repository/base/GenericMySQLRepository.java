package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericMySQLRepository<T,ID> extends JpaRepository<T,ID> {
}
