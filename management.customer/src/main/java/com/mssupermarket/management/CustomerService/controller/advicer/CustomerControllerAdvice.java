package com.mssupermarket.management.CustomerService.controller.advicer;

import com.mssupermarket.management.CustomerService.commons.CustomResponse;
import com.mssupermarket.management.CustomerService.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<CustomResponse> customerNotFoundException (CustomerNotFoundException exc){
        CustomResponse customResponse = new CustomResponse();

        customResponse.setMessage("Customer not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customResponse);

    }
}
