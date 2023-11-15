package com.mssupermarket.management.CustomerService.controller;

import com.mssupermarket.management.CustomerService.DTO.CustomerViewDTO;
import com.mssupermarket.management.CustomerService.commons.CustomResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerController {
    ResponseEntity<CustomResponse> getCustomerById(Long id);
    ResponseEntity<CustomResponse> saveCustomer(CustomerViewDTO customerViewDTO);
}
