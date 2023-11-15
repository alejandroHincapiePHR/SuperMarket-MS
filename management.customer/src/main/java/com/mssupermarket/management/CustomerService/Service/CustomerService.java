package com.mssupermarket.management.CustomerService.Service;

import com.mssupermarket.management.CustomerService.DTO.CustomerViewDTO;


public interface CustomerService {
    CustomerViewDTO getCustomerById(Long id);
    Boolean SaveCustomer(CustomerViewDTO customerViewDTO);
}
