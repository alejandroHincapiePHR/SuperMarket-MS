package com.ms.supermarket.management.bill.adapters.in.api.rest.mapper;

import com.ms.supermarket.management.bill.adapters.in.api.rest.dto.InvoiceLineItemDTO;
import com.ms.supermarket.management.bill.application.service.ProductService;
import com.ms.supermarket.management.bill.domain.finance.InvoiceLineItem;
import com.ms.supermarket.management.bill.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InvoiceLineItemDTOMapperImp implements  InvoiceLineItemDTOMapper{

    private ProductService productService;

    @Autowired
    public InvoiceLineItemDTOMapperImp(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public InvoiceLineItemDTO toDTO(InvoiceLineItem i) {
        Product product;
        Optional<Product> productOptional = productService.getProductById(i.getProduct().getId());
        if(productOptional.isPresent()){
            product = productOptional.get();
        }else{
            product = new Product();
            product.setProductName("Product not found");
        }
        InvoiceLineItemDTO invoiceLineItemDTO = InvoiceLineItemDTO.builder()
                .productName(product.getProductName())
                .quantity(i.getQuantity())
                .subtotal(i.getSubtotal())
                .build();
        return invoiceLineItemDTO;
    }

    @Override
    public List<InvoiceLineItemDTO> toDTOList(List<InvoiceLineItem> i) {
       return i.stream().map(this::toDTO).toList();
    }
}
