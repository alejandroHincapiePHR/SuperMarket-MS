package com.ms.supermarket.management.bill.application.ports.bill.in;

import com.ms.supermarket.management.bill.domain.admin.Customer;
import com.ms.supermarket.management.bill.domain.product.Product;

import java.util.List;

@FunctionalInterface
public interface BillCreationUseCase {

    Long billCreationUseCase(Customer customer, List<Product> products);

}
