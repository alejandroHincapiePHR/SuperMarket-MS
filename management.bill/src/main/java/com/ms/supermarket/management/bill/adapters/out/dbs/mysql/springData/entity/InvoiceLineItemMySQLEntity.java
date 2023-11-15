package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "invoice_line_item")
public class InvoiceLineItemMySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_line_item_id")
    private Long invoiceLineItemId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "taxes")
    private Double taxes;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "points")
    private Double points;
}

