package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "bill")
public class BillMySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "customer_id")
    private Long customerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "total_line_item_id")
    private TotalLineItemMySQLEntity totalLineItem;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "bill_invoice_line_item",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "invoice_line_item_id")
    )
    private List<InvoiceLineItemMySQLEntity> lineItems;


}
