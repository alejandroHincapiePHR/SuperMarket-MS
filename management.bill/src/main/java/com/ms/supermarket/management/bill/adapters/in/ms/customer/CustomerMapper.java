package com.ms.supermarket.management.bill.adapters.in.ms.customer;

import com.ms.supermarket.management.bill.domain.admin.Customer;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "id", target = "customerId")
    })
    CustomerDTO toDTO(Customer customer);

    @InheritInverseConfiguration
    Customer toEntity(CustomerDTO customerDTO);
}
