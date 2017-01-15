package com.pluralsight.services;

import com.pluralsight.models.Customer;
import com.pluralsight.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void CustomerServiceImpl(CustomerRepository customerRepository) {
        System.out.println("We are using constructor injection.");
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
