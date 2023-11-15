package com.ms.supermarket.management.bill.application.ports.product.in;


import com.ms.supermarket.management.bill.domain.product.Product;

import java.util.List;

@FunctionalInterface
public interface SkuListToProductListUseCase {

    List<Product> skuListToProductList(List<String> skuList);
}
