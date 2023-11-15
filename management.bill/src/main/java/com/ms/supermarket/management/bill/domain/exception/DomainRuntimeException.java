package com.ms.supermarket.management.bill.domain.exception;

public class DomainRuntimeException extends RuntimeException {
    public DomainRuntimeException() {
    }
    public DomainRuntimeException(String message) {
        super(message);
    }
}
