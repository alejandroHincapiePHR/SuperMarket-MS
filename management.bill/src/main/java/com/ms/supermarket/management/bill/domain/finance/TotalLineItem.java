package com.ms.supermarket.management.bill.domain.finance;

import com.ms.supermarket.management.bill.domain.base.Domain;
import com.ms.supermarket.management.bill.domain.exception.DomainRuntimeException;
import com.ms.supermarket.management.bill.domain.exception.InvalidResultException;

import java.util.List;

public final class TotalLineItem extends Domain {
    private Integer totalQuantityProducts;
    private Double totalTaxes;
    private Double totalToPay;
    private Double totalAccumulatedPoints;
    private List<InvoiceLineItem> lineItems;


    public TotalLineItem() {
    }

    public TotalLineItem(List<InvoiceLineItem> lineItems) {
        validArgumentCheck(lineItems);
        this.lineItems = lineItems;
        this.totalQuantityProducts = calculateTotalQuantityProducts();
        this.totalTaxes = calculateTotalTaxes();
        this.totalToPay = calculateTotalToPay();
        this.totalAccumulatedPoints = calculateTotalAccumulatedPoints();
    }

    private void validArgumentCheck(List<InvoiceLineItem> lineItems) {
        if (lineItems==null){
            throw new DomainRuntimeException("Total can not be calculated with current arguments");
        }
    }

    private void checkNegative(double result) throws InvalidResultException {
        if (result <0){
            throw new InvalidResultException("Value should not be negative in Total Line Item Domain Class");
        }
    }

    private Double calculateTotalAccumulatedPoints() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getPoints).reduce(0D, Double::sum);
        checkNegative(reduce);
        return reduce;
    }

    private Double calculateTotalToPay() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getSubtotal).reduce(0D, Double::sum);
        checkNegative(reduce);

        return reduce;
    }

    private Double calculateTotalTaxes() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getTaxes).reduce(0D, Double::sum);
        checkNegative(reduce);
         return reduce;
    }

    private Integer calculateTotalQuantityProducts() {
        Integer reduce = lineItems.stream().map(InvoiceLineItem::getQuantity).reduce(0, Integer::sum);
        checkNegative(reduce);
        return reduce;
    }

    public Integer getTotalQuantityProducts() {
        return totalQuantityProducts;
    }


    public Double getTotalTaxes() {
        return totalTaxes;
    }


    public Double getTotalToPay() {
        return totalToPay;
    }

    public Double getTotalAccumulatedPoints() {
        return totalAccumulatedPoints;
    }

    public List<InvoiceLineItem> getLineItems() {
        return lineItems;
    }

    public void setTotalQuantityProducts(Integer totalQuantityProducts) {
        this.totalQuantityProducts = totalQuantityProducts;
    }

    public void setTotalTaxes(Double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public void setTotalToPay(Double totalToPay) {
        this.totalToPay = totalToPay;
    }

    public void setTotalAccumulatedPoints(Double totalAccumulatedPoints) {
        this.totalAccumulatedPoints = totalAccumulatedPoints;
    }

    public void setLineItems(List<InvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
