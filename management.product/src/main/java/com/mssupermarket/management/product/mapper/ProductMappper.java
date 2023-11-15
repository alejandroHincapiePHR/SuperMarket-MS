package com.mssupermarket.management.product.mapper;

import com.mssupermarket.management.product.dto.ProductDTO;
import com.mssupermarket.management.product.entity.ProductMySQLEntity;
import org.mapstruct.*;

import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMappper {

    @Mappings({
            @Mapping(source = "customerCost", target = "price"),
    })
    ProductDTO toDTO(ProductMySQLEntity productMySQLEntity);

    @InheritInverseConfiguration
    ProductMySQLEntity toEntity (ProductDTO productDTO);

    List<ProductDTO> listToDTO(List<ProductMySQLEntity> productMySQLEntityList);

    List<ProductMySQLEntity> listToEntity(List<ProductDTO> productDTOList);


}
