package com.ms.supermarket.management.bill.domain.finance;

import com.ms.supermarket.management.bill.domain.base.Domain;
import com.ms.supermarket.management.bill.domain.exception.InvalidResultException;
import com.ms.supermarket.management.bill.domain.product.Product;
import lombok.Builder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public final class InvoiceLineItem extends Domain {

    private Product product;
    private Integer quantity;
    private Double taxes;
    private Double discount;
    private Double subtotal;
    private Double points;
    private static Double taxesPCT;
    private static Double pointsPCT;
    private static Double discountPCT;

    static{
        taxesPCT = 0.15D;
        pointsPCT = 0.1D;
        discountPCT = 0.05D;
    }


    public InvoiceLineItem() {
    }

    public InvoiceLineItem(Long productId, Integer quantity, Double taxes, Double discount, Double subtotal, Double points) {
        this.product = new Product(productId);
        this.quantity = quantity;
        this.taxes = taxes;
        this.discount = discount;
        this.subtotal = subtotal;
        this.points = points;
      }

    public InvoiceLineItem(Product product, Integer quantity) throws InvalidResultException {
        validateArguments(product, quantity);
        this.product = product;
        this.quantity = quantity;
        this.points = calculateSubTotalPoints(product.getCustomerCost());
        this.taxes = calculateSubTotalTaxes(product.getCustomerCost());
        this.discount = calculateSubTotalDiscount(product.getCustomerCost());
        this.subtotal = calculateSubTotal(product.getCustomerCost(), quantity);
    }

    private static void validateArguments(Product product, Integer quantity) {
        if(product == null || quantity <= 0 ){
            throw new IllegalArgumentException("invalid arguments");
        }

    }

    private Double calculateSubTotal(Double customerCost, Integer quantity) throws InvalidResultException {
        double result = (customerCost + (taxes) - (discount)) * quantity;
        checkNegative(result);
        return result;

    }

    private void checkNegative(double result) throws InvalidResultException {
        if (result <0){
            throw new InvalidResultException("Value should not be negative (InvoiceLineItem Domain class)");
        }
    }

    private Double calculateSubTotalDiscount(Double customerCost) throws InvalidResultException {
        double result = customerCost * discountPCT;
        checkNegative(result);
        return result;
    }
    private Double calculateSubTotalTaxes(Double customerCost) throws InvalidResultException {
        double result = customerCost * taxesPCT;
        checkNegative(result);
        return result;
    }

    private Double calculateSubTotalPoints(Double customerCost) throws InvalidResultException {

        double result = customerCost * pointsPCT;
        checkNegative(result);
        return result;
    }


    private String getDayInUpperCase() {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        String dayInUpperCase = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();
        return dayInUpperCase;
    }


    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTaxes() {
        return taxes;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getPoints() {
        return points;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
