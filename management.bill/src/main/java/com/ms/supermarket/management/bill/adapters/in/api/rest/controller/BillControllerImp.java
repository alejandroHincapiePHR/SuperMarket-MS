package com.ms.supermarket.management.bill.adapters.in.api.rest.controller;

import com.ms.supermarket.management.bill.adapters.in.api.rest.ErorHandling.SkuListObjectNullException;
import com.ms.supermarket.management.bill.adapters.in.api.rest.commons.CustomResponse;
import com.ms.supermarket.management.bill.adapters.in.api.rest.commons.SkuListObject;
import com.ms.supermarket.management.bill.adapters.in.api.rest.mapper.BillDTOMapper;
import com.ms.supermarket.management.bill.application.exceptions.BillNotFoundException;
import com.ms.supermarket.management.bill.application.exceptions.CustomerNotFoundException;
import com.ms.supermarket.management.bill.application.exceptions.EmployeeNotFoundException;
import com.ms.supermarket.management.bill.application.exceptions.ProductNotFoundException;
import com.ms.supermarket.management.bill.application.service.BillService;
import com.ms.supermarket.management.bill.application.service.CustomerService;

import com.ms.supermarket.management.bill.application.service.ProductService;
import com.ms.supermarket.management.bill.domain.admin.Customer;

import com.ms.supermarket.management.bill.domain.finance.Bill;
import com.ms.supermarket.management.bill.domain.product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ms.supermarket.management.bill.adapters.in.api.rest.constant.ApiGlobalConstant.*;
import static com.ms.supermarket.management.bill.adapters.in.api.rest.constant.ApiMethodsConstants.*;
import static com.ms.supermarket.management.bill.adapters.in.api.rest.constant.MessageConstants.*;

@RestController
@RequestMapping(API_BILL)
public class BillControllerImp {

    private BillService billService;
    private CustomerService customerService;
    private ProductService productService;

    private BillDTOMapper billDTOMapper;

    @Autowired
    public BillControllerImp(BillService billService, CustomerService customerService, ProductService productService, BillDTOMapper billDTOMapper) {
        this.billService = billService;
        this.customerService = customerService;
        this.productService = productService;
        this.billDTOMapper = billDTOMapper;
    }

    /**
     * Method that creates a bill in SuperMarket Java API.
     *
     * @param idCustomer

     * @param skuListObject
     * @return ResponseEntity with a Response<BillId> object and the HTTP status
     * @author Alejandro Hincapie
     * @since 06/10/2023
     */

    @PostMapping("/{idCustomer}")
    public ResponseEntity<CustomResponse> createBill(
            @PathVariable(name = "idCustomer") Integer idCustomer,
            @RequestBody SkuListObject skuListObject) throws ProductNotFoundException,
            CustomerNotFoundException, SkuListObjectNullException {

        if (skuListObject.getSkuList() == null) {
            throw new SkuListObjectNullException();
        }
        Customer customer = customerService.customerById(idCustomer.longValue());
        List<Product> products = productService.skuListToProductList(skuListObject.getSkuList());
        Long billId = billService.billCreationUseCase(customer, products);

        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(API_BILL);
        customResponse.setMethod(CREATE_BILL);
        customResponse.setCode("201");
        customResponse.setMessage(MSG_RESPONSE_OK);
        customResponse.setResponse(billId);

        return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
    }


    @GetMapping("/{idBill}")
    public ResponseEntity<CustomResponse> getBillById(
            @PathVariable(name = "idBill") Long idBill) throws BillNotFoundException {
        Bill bill = billService.getBillByIdUseCase(idBill);
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(API_BILL);
        customResponse.setMethod(BILL_BY_ID);
        customResponse.setCode("200");
        customResponse.setMessage(MSG_RESPONSE_OK);
        customResponse.setResponse(billDTOMapper.toDTO(bill));
        return ResponseEntity.status(HttpStatus.FOUND).body(customResponse);
    }


}
