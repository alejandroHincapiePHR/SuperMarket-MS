package com.ms.supermarket.management.bill.adapters.in.ms.customer;


import com.ms.supermarket.management.bill.application.ports.admin.customer.out.CustomerByIdPort;
import com.ms.supermarket.management.bill.domain.admin.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImp implements CustomerByIdPort {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;
    private final String msName = "management.customer";
    private CircuitBreaker circuitBreaker;

    private CustomerMapper customerMapper;

    private String url = "";

    @Autowired
    public CustomerServiceImp(@Qualifier("customerRestTemplate")RestTemplate restTemplate, DiscoveryClient discoveryClient,
                              CircuitBreakerFactory<?, ?> circuitBreakerFactory, CustomerMapper customerMapper) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.circuitBreaker = circuitBreakerFactory.create(msName);
        this.customerMapper = customerMapper;
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return circuitBreaker.run(() -> {
                    this.url = this.getURI(this.msName) + "/api/v1/customer/" + id;
                    log.info("url {}", url);
                    ResponseEntity<CustomerCustomResponseDTO> customResponseEntity = restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            CustomerCustomResponseDTO.class
                    );

                    if (!Objects.isNull(customResponseEntity.getBody().getResponse())) {
                        log.info("customResponseEntity {} ", customResponseEntity);
                        CustomerDTO customerDTO = customResponseEntity.getBody().getResponse();
                        return Optional.of(customerMapper.toEntity(customerDTO));
                    } else {
                        log.info("CustomerDTO is null");
                        return null;
                    }
                },
                throwable -> getCustomerBackup()
        );
    }

    private Optional<Customer> getCustomerBackup() {
        log.info("Customer backup activated: customer is null");
        CustomerDTO customerDTO = new CustomerDTO();
        return Optional.of(customerMapper.toEntity(customerDTO));
    }


    private String getURI(String ms) {

        if (Objects.isNull(discoveryClient)) {
            log.info("discoveryClient is null");
            return null;
        }

        List<ServiceInstance> instances = discoveryClient.getInstances(ms);

        if (Objects.isNull(instances) || instances.isEmpty()) {
            log.info("instances is null");
            return null;
        }
        String uri = instances.get(0).getUri().toString();
        log.info("uri => {}", uri);
        return uri;

    }
}



