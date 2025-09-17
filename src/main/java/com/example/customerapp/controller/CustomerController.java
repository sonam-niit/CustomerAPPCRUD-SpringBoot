package com.example.customerapp.controller;

import com.example.customerapp.entity.Customer;
import com.example.customerapp.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public String addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
        return "Customer added successfully!";
    }

    // READ - All
    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    // READ - By ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        service.updateCustomer(customer);
        return "Customer updated successfully!";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        service.deleteCustomer(id);
        return "Customer deleted successfully!";
    }
}
