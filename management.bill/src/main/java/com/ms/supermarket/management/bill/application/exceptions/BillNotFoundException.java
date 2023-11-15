package com.ms.supermarket.management.bill.application.exceptions;

public class BillNotFoundException extends RuntimeException{

    public BillNotFoundException() {
        super();
    }

    public BillNotFoundException(String message) {
        super(message);
    }

    public BillNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BillNotFoundException(Throwable cause) {
        super(cause);
    }
}
