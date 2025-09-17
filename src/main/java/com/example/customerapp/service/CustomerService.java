package com.example.customerapp.service;

import com.example.customerapp.entity.Customer;
import com.example.customerapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void addCustomer(Customer customer) {
        repository.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return repository.getCustomerById(id);
    }

    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        repository.deleteCustomer(id);
    }
}
