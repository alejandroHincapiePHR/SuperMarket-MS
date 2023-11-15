package com.mssupermarket.management.CustomerService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CustomerViewDTO {
    private Long customerId;
    private Integer points;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
