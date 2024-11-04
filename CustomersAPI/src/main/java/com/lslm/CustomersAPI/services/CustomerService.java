package com.lslm.CustomersAPI.services;

import com.lslm.CustomersAPI.dtos.CustomerRegistrationRequest;
import com.lslm.CustomersAPI.models.Customer;
import com.lslm.CustomersAPI.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = new Customer();
        customer.setName(customerRegistrationRequest.name());
        customer.setEmail(customerRegistrationRequest.email());
        return customerRepository.save(customer);
    }

    public Optional<Customer> findOne(UUID id) {
        return customerRepository.findById(id);
    }
}
