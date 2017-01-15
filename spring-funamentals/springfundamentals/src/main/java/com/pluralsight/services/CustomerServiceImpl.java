package com.pluralsight.services;

import com.pluralsight.models.Customer;
import com.pluralsight.repositories.CustomerRepository;
import com.pluralsight.repositories.HibernateCustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new HibernateCustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
