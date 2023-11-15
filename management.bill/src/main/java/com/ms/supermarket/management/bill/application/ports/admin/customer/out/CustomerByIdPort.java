package com.ms.supermarket.management.bill.application.ports.admin.customer.out;

import com.ms.supermarket.management.bill.domain.admin.Customer;


import java.util.Optional;

@FunctionalInterface
public interface CustomerByIdPort {

    Optional<Customer> getCustomerById(Long id);
}
