package com.ms.supermarket.management.bill.application.ports.admin.customer.in;


import com.ms.supermarket.management.bill.domain.admin.Customer;

@FunctionalInterface
public interface CustomerByIdUseCase {

    Customer customerById(Long id);

}
