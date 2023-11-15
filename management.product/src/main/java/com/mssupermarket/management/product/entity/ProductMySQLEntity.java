package com.mssupermarket.management.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductMySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sku")
    private String sku;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "available_units")
    private Integer availableUnits;
    @Column(name = "customer_cost")
    private Double customerCost;
    @Column(name = "company_cost")
    private Double companyCost;

}
