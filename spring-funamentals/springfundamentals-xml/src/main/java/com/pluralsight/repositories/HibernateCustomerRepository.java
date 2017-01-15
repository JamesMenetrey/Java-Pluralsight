package com.pluralsight.repositories;

import com.pluralsight.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerRepository implements CustomerRepository {
    private String dbUsername;

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

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
