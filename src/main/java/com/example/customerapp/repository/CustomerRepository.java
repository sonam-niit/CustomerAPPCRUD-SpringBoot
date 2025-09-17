package com.example.customerapp.repository;

import com.example.customerapp.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    // CREATE
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // READ
    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public void updateCustomer(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == customer.getId()) {
                customers.set(i, customer);
                return;
            }
        }
    }

    // DELETE
    public void deleteCustomer(int id) {
        customers.removeIf(c -> c.getId() == id);
    }
}
