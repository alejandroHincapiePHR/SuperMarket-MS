package com.ms.supermarket.management.bill.domain.product;

import com.ms.supermarket.management.bill.domain.base.Domain;



public final class Product extends Domain {
    private String SKU;
    private String productName;
    private Double customerCost;

    public Product() {
        super();
    }

    public Product(Long id) {
        super(id);
    }

    public Product(Long id, String SKU, String productName, Double customerCost) {
        super(id);
        this.SKU = SKU;
        this.productName = productName;
        this.customerCost = customerCost;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getCustomerCost() {
        return customerCost;
    }

    public void setCustomerCost(Double customerCost) {
        this.customerCost = customerCost;
    }
}
