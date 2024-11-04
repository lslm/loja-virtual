package com.lslm.CustomersAPI.controllers;

import com.lslm.CustomersAPI.dtos.CustomerRegistrationRequest;
import com.lslm.CustomersAPI.dtos.CustomerRegistrationResponse;
import com.lslm.CustomersAPI.dtos.CustomerResponse;
import com.lslm.CustomersAPI.models.Customer;
import com.lslm.CustomersAPI.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerRegistrationResponse> create(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = customerService.create(customerRegistrationRequest);

        CustomerRegistrationResponse customerRegistrationResponse = new CustomerRegistrationResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );

        return new ResponseEntity<>(customerRegistrationResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> findOne(@PathVariable UUID customerId) {
        Optional<Customer> maybeCustomer = customerService.findOne(customerId);

        if (maybeCustomer.isPresent()) {
            Customer customer = maybeCustomer.get();
            CustomerResponse customerResponse = new CustomerResponse(
                    customer.getId(),
                    customer.getName(),
                    customer.getEmail()
            );
            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
