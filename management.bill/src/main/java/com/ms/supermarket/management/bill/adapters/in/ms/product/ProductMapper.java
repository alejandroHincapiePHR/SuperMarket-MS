package com.ms.supermarket.management.bill.adapters.in.ms.product;

import com.ms.supermarket.management.bill.adapters.in.ms.customer.CustomerDTO;
import com.ms.supermarket.management.bill.domain.admin.Customer;
import com.ms.supermarket.management.bill.domain.product.Product;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "SKU", target = "sku"),
            @Mapping(source = "customerCost", target = "price")
    })
    ProductDTO toDTO(Product product);

    @InheritInverseConfiguration
    Product toEntity(ProductDTO productDTO);

}
