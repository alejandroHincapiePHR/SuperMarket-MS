package com.mssupermarket.management.CustomerService.Service;

import com.mssupermarket.management.CustomerService.DTO.CustomerViewDTO;
import com.mssupermarket.management.CustomerService.entitty.CustomerMySQLEntity;
import com.mssupermarket.management.CustomerService.exceptions.CustomerEmptyException;
import com.mssupermarket.management.CustomerService.exceptions.CustomerNotFoundException;
import com.mssupermarket.management.CustomerService.mappers.CustomerMapper;
import com.mssupermarket.management.CustomerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerViewDTO getCustomerById(Long id) throws CustomerNotFoundException {
        Optional<CustomerMySQLEntity> customerMySQLEntityOptional = customerRepository.findById(id);
        if (customerMySQLEntityOptional.isEmpty()) {
            throw new CustomerNotFoundException();
        }
        return customerMapper.toDTO(customerMySQLEntityOptional.get());
    }

    @Override
    public Boolean SaveCustomer(CustomerViewDTO customerViewDTO) throws CustomerEmptyException {
        if (customerViewDTO == null) {
            throw new CustomerEmptyException();
        }
        CustomerMySQLEntity customerMySQLEntity = customerRepository.save(customerMapper.toEntity(customerViewDTO));
        return customerRepository.existsById(customerMySQLEntity.getCustomerId());
    }
}
