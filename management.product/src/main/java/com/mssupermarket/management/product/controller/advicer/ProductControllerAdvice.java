package com.mssupermarket.management.product.controller.advicer;

import com.mssupermarket.management.product.commons.CustomResponse;
import com.mssupermarket.management.product.exeptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<CustomResponse> productNotFoundException (ProductNotFoundException exc){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setResponse("Product not found");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customResponse);

    }


}
