package com.mssupermarket.management.CustomerService.repository;

import com.mssupermarket.management.CustomerService.entitty.CustomerMySQLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerMySQLEntity, Long> {
}
