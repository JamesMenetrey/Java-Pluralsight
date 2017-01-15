package com.pluralsight.services;

import com.pluralsight.models.Customer;

import java.util.List;

/**
 * Created by james on 15.01.2017.
 */
public interface CustomerService {
    List<Customer> findAll();
}
