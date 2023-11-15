package com.ms.supermarket.management.bill.domain.finance;

import com.ms.supermarket.management.bill.domain.admin.Customer;
import com.ms.supermarket.management.bill.domain.base.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public final class Bill extends Domain {
    private Date issueDate;
    private Customer customer;
    private List<InvoiceLineItem> lineItems;
    private TotalLineItem totalLineItem;
    private Boolean isClosed;

    public Bill(Customer customer) {
        super();
        this.customer = customer;
        this.issueDate = setIssueDate();
        this.lineItems = new ArrayList<>();
        this.isClosed = false;
    }

    public Bill(Long id, Customer customer,Date issueDate, List<InvoiceLineItem> lineItems, TotalLineItem totalLineItem) {
        super(id);
        this.issueDate = issueDate;
        this.customer = customer;
        this.lineItems = lineItems;
        this.totalLineItem = totalLineItem;

    }

    public void confirmBillAndGetTotalLineItem(Boolean isEmployee) {
        if (isEmployee == null) {
            throw new IllegalArgumentException("Data arguments are not valid");
        }
        isClosed = true;
        totalLineItem = new TotalLineItem(lineItems);
    }


    public TotalLineItem getTotalLineItem() {
        return totalLineItem;
    }

    public void setTotalLineItem(TotalLineItem totalLineItem) {
        this.totalLineItem = totalLineItem;
    }

    private Date setIssueDate() {
        LocalDate currentDate = LocalDate.now();
        return java.sql.Date.valueOf(currentDate);
    }

    public Date getIssueDate() {
        return issueDate;
    }



    public List<InvoiceLineItem> getLineItems() {
        if (lineItems == null) {
            return null;
        } else {

            return lineItems;
        }
    }

    public Boolean setLineItem(InvoiceLineItem lineItem) {
        if (lineItem != null) {
            this.lineItems.add(lineItem);
            return true;
        } else {
            return false;
        }
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setLineItems(List<InvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }
}
