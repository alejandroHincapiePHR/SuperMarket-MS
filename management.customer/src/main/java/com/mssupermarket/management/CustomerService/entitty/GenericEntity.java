package com.mssupermarket.management.CustomerService.entitty;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class GenericEntity {
    @Column(name = "status")
    private String status;
}
