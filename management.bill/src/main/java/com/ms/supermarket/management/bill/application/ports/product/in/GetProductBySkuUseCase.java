package com.ms.supermarket.management.bill.application.ports.product.in;

import com.ms.supermarket.management.bill.domain.product.Product;

import java.util.Optional;

@FunctionalInterface
public interface GetProductBySkuUseCase {
    Optional<Product> getProductBySku(String SKU);
}
