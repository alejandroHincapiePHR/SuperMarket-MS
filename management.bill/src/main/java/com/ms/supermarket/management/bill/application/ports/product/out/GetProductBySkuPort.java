package com.ms.supermarket.management.bill.application.ports.product.out;

import com.ms.supermarket.management.bill.domain.product.Product;

import java.util.Optional;

@FunctionalInterface
public interface GetProductBySkuPort {
    Optional<Product> getProductBySKU(String SKU);
}
