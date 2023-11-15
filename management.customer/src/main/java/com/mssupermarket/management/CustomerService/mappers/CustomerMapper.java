package com.mssupermarket.management.CustomerService.mappers;

import com.mssupermarket.management.CustomerService.DTO.CustomerViewDTO;
import com.mssupermarket.management.CustomerService.entitty.CustomerMySQLEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName")
    })
    CustomerViewDTO toDTO(CustomerMySQLEntity customerMySQLEntity);


    @InheritInverseConfiguration
    CustomerMySQLEntity toEntity(CustomerViewDTO customerViewDTO);

}
