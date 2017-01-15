package com.pluralsight.repositories;

import com.pluralsight.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HibernateCustomerRepository implements CustomerRepository {
    @Value("${dbUsername}")
    private String dbUsername;

    @Override
    public List<Customer> findAll() {
        System.out.println(dbUsername);

        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer();
        customer.setFirstname("Jämes");
        customer.setLastname("Ménétrey");

        customers.add(customer);

        return customers;
    }
}
