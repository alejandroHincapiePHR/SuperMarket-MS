package com.mssupermarket.management.product.service;

import com.mssupermarket.management.product.dto.ProductDTO;
import com.mssupermarket.management.product.entity.ProductMySQLEntity;
import com.mssupermarket.management.product.exeptions.ProductNotFoundException;
import com.mssupermarket.management.product.mapper.ProductMappper;
import com.mssupermarket.management.product.repository.ProductJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {

    private ProductJPARepository productJPARepository;

    private ProductMappper productMappper;

    @Autowired
    public ProductServiceImp(ProductJPARepository productJPARepository, ProductMappper productMappper) {
        this.productJPARepository = productJPARepository;
        this.productMappper = productMappper;
    }

    @Override
    public ProductDTO getProductBySku(String sku) throws ProductNotFoundException {
        ProductMySQLEntity productMySQLEntity = productJPARepository.findBySku(sku)
                .orElseThrow(()->new ProductNotFoundException());
        return productMappper.toDTO(productMySQLEntity);
    }

    @Override
    public ProductDTO getProductById(Long id)throws ProductNotFoundException  {
        ProductMySQLEntity productMySQLEntity = productJPARepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException());
        return productMappper.toDTO(productMySQLEntity);
    }
}
