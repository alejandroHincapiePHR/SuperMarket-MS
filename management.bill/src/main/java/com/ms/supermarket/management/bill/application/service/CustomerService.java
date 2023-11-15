package com.ms.supermarket.management.bill.application.service;

import com.ms.supermarket.management.bill.application.exceptions.CustomerNotFoundException;
import com.ms.supermarket.management.bill.application.ports.admin.customer.in.CustomerByIdUseCase;
import com.ms.supermarket.management.bill.application.ports.admin.customer.out.CustomerByIdPort;
import com.ms.supermarket.management.bill.domain.admin.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements CustomerByIdUseCase {
    private CustomerByIdPort customerByIdPort;

    @Autowired
    public CustomerService(final CustomerByIdPort customerByIdPort) {
        this.customerByIdPort = customerByIdPort;
    }

    @Override
    public Customer customerById(Long id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerByIdPort.getCustomerById(id);
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException();
        }
        return customerOptional.get();
    }
}
