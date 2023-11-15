package com.ms.supermarket.management.bill.adapters.in.ms.product;

import com.ms.supermarket.management.bill.application.ports.product.out.GetProductByIdPort;
import com.ms.supermarket.management.bill.application.ports.product.out.GetProductBySkuPort;
import com.ms.supermarket.management.bill.domain.product.Product;
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
public class ProductServiceImp implements GetProductBySkuPort, GetProductByIdPort {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;
    private final String msName = "management.product";
    private CircuitBreaker circuitBreaker;

    private ProductMapper productMapper;

    private String url = "";

    @Autowired
    public ProductServiceImp(@Qualifier("productRestTemplate") RestTemplate restTemplate, DiscoveryClient discoveryClient,
                              CircuitBreakerFactory<?, ?> circuitBreakerFactory, ProductMapper productMapper) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.circuitBreaker = circuitBreakerFactory.create(msName);
        this.productMapper = productMapper;
    }


    @Override
    public Optional<Product> getProductBySKU(String sku) {
        return circuitBreaker.run(() -> {
                    this.url = this.getURI(this.msName) + "/api/v1/product/" + sku;
                    log.info("url {}", url);
                    ResponseEntity<ProductCustomResponseDTO> customResponseEntity = restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            ProductCustomResponseDTO.class
                    );

                    if (!Objects.isNull(customResponseEntity.getBody().getResponse())) {
                        log.info("customResponseEntity {} ", customResponseEntity);
                        ProductDTO productDTO = customResponseEntity.getBody().getResponse();
                        Product entity = productMapper.toEntity(productDTO);
                        log.info("Product Domain entity {} ", entity);
                        return Optional.of(entity);
                    } else {
                        log.info("ProductDTO is null");
                        return null;
                    }
                },
                throwable -> getProductBackup()
        );
    }

    private Optional<Product> getProductBackup() {
        log.info("Product backup activated: customer is null");
        ProductDTO productDTO = new ProductDTO();

        return Optional.of(productMapper.toEntity(productDTO));
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


    @Override
    public Optional<Product> getProductById(Long id) {
        return circuitBreaker.run(() -> {
                    this.url = this.getURI(this.msName) + "/api/v1/product/id/" + id;
                    log.info("url {}", url);
                    ResponseEntity<ProductCustomResponseDTO> customResponseEntity = restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            ProductCustomResponseDTO.class
                    );

                    if (!Objects.isNull(customResponseEntity.getBody().getResponse())) {
                        log.info("customResponseEntity {} ", customResponseEntity);
                        ProductDTO productDTO = customResponseEntity.getBody().getResponse();
                        Product entity = productMapper.toEntity(productDTO);
                        log.info("Product Domain entity {} ", entity);
                        return Optional.of(entity);
                    } else {
                        log.info("ProductDTO is null");
                        return null;
                    }
                },
                throwable -> getProductBackup()
        );
    }




}
