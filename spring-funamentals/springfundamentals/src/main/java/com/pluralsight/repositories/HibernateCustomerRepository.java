package com.pluralsight.repositories;

import com.pluralsight.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerRepository implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer();
        customer.setFirstname("Jämes");
        customer.setLastname("Ménétrey");

        customers.add(customer);

        return customers;
    }
}
