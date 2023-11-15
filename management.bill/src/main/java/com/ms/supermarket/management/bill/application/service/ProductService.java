package com.ms.supermarket.management.bill.application.service;

import com.ms.supermarket.management.bill.application.exceptions.ProductNotFoundException;
import com.ms.supermarket.management.bill.application.ports.product.in.GetProductByIdUseCase;
import com.ms.supermarket.management.bill.application.ports.product.in.GetProductBySkuUseCase;
import com.ms.supermarket.management.bill.application.ports.product.in.SkuListToProductListUseCase;
import com.ms.supermarket.management.bill.application.ports.product.out.GetProductByIdPort;
import com.ms.supermarket.management.bill.application.ports.product.out.GetProductBySkuPort;
import com.ms.supermarket.management.bill.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements GetProductBySkuUseCase, SkuListToProductListUseCase, GetProductByIdUseCase {

    private GetProductBySkuPort getProductBySkuPort;

    private GetProductByIdPort getProductByIdPort;

    @Autowired
    public ProductService(GetProductBySkuPort getProductBySkuPort, GetProductByIdPort getProductByIdPort) {
        this.getProductBySkuPort = getProductBySkuPort;
        this.getProductByIdPort = getProductByIdPort;
    }

    @Override
    public Optional<Product> getProductBySku(String SKU) {
        return getProductBySkuPort.getProductBySKU(SKU);
    }

    @Override
    public List<Product> skuListToProductList(List<String> skuList) throws ProductNotFoundException {

        List<Optional<Product>> productListOptional = skuList.stream().map(x -> getProductBySkuPort.getProductBySKU(x)).toList();
        productListOptional.stream().forEach(x -> {
            if (x.isEmpty()) {
                throw new ProductNotFoundException();
            }
        });
        return productListOptional.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return getProductByIdPort.getProductById(id);
    }
}
