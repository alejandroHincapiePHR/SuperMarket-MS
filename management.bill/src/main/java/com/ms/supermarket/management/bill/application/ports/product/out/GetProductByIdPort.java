package com.ms.supermarket.management.bill.application.ports.product.out;

import com.ms.supermarket.management.bill.domain.product.Product;

import java.util.Optional;

public interface GetProductByIdPort {

    Optional<Product> getProductById(Long id);
}
