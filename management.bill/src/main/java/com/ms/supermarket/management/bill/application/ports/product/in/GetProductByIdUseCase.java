package com.ms.supermarket.management.bill.application.ports.product.in;

import com.ms.supermarket.management.bill.domain.product.Product;

import java.util.Optional;
@FunctionalInterface
public interface GetProductByIdUseCase {
    Optional<Product> getProductById(Long id);
}
