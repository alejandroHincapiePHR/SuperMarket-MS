package com.mssupermarket.management.CustomerService.controller;

import com.mssupermarket.management.CustomerService.DTO.CustomerViewDTO;
import com.mssupermarket.management.CustomerService.Service.CustomerService;
import com.mssupermarket.management.CustomerService.commons.CustomResponse;
import com.mssupermarket.management.CustomerService.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerControllerImp implements CustomerController {


    private CustomerService customerService;

    @Autowired
    public CustomerControllerImp(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getCustomerById(@PathVariable(name = "id") Long id) throws CustomerNotFoundException {
        CustomerViewDTO customerViewDTO = customerService.getCustomerById(id);

        CustomResponse customResponse = CustomResponse.builder()
                .api("/api/v1/customer")
                .code("200")
                .response(customerViewDTO)
                .build();

        return ResponseEntity.status(HttpStatus.FOUND).body(customResponse);
    }

    @Override
    public ResponseEntity<CustomResponse> saveCustomer(CustomerViewDTO customerViewDTO) {
        return null;
    }
}
