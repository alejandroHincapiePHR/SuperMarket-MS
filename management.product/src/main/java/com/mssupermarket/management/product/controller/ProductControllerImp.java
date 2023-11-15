package com.mssupermarket.management.product.controller;

import com.mssupermarket.management.product.commons.CustomResponse;
import com.mssupermarket.management.product.dto.ProductDTO;
import com.mssupermarket.management.product.exeptions.ProductNotFoundException;
import com.mssupermarket.management.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductControllerImp implements ProductController {

    private ProductService productService;

    @Autowired
    public ProductControllerImp(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{sku}")
    public ResponseEntity<CustomResponse> getProductBySku(
            @PathVariable(name = "sku") String sku) throws ProductNotFoundException {
        ProductDTO productDTO = productService.getProductBySku(sku);
        CustomResponse customResponse = CustomResponse.builder()
                .response(productDTO)
                .code("201")
                .api("/api/v1/product")
                .method("GET")
                .build();
        return ResponseEntity.status(HttpStatus.FOUND).body(customResponse);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomResponse> getProductById(
            @PathVariable(name = "id") Long id) throws ProductNotFoundException {
        ProductDTO productDTO = productService.getProductById(id);
        CustomResponse customResponse = CustomResponse.builder()
                .response(productDTO)
                .code("201")
                .api("/api/v1/product")
                .method("GET")
                .build();
        return ResponseEntity.status(HttpStatus.FOUND).body(customResponse);
    }
}
