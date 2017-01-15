package com.pluralsight.repositories;

import com.pluralsight.models.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
}
