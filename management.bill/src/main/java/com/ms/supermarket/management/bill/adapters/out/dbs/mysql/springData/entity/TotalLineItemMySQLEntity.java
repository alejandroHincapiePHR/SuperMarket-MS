package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "total_line_item")
public class TotalLineItemMySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "total_line_item_id")
    private Long totalLineItemId;

    @Column(name = "total_quantity_products")
    private Integer totalQuantityProducts;

    @Column(name = "total_taxes")
    private Double totalTaxes;

    @Column(name = "total_to_pay")
    private Double totalToPay;

    @Column(name = "total_accumulated_points")
    private Double totalAccumulatedPoints;
}


