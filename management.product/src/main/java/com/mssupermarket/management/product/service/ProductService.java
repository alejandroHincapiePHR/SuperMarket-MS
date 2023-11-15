package com.mssupermarket.management.product.service;

import com.mssupermarket.management.product.dto.ProductDTO;

public interface ProductService {
    ProductDTO getProductBySku(String sku);

    ProductDTO getProductById(Long id);
}
