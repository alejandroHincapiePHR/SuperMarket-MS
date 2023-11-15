package com.mssupermarket.management.product.controller;

import com.mssupermarket.management.product.commons.CustomResponse;
import org.springframework.http.ResponseEntity;

public interface ProductController {

    ResponseEntity<CustomResponse> getProductBySku(String sku);

    ResponseEntity<CustomResponse> getProductById(Long id);

}
