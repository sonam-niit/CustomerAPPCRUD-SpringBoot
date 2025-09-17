package com.example.customerapp;

import com.example.customerapp.entity.Customer;
import com.example.customerapp.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerRepositoryTest {

    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        customerRepository = new CustomerRepository(); // fresh repo before each test
    }

    // Test Add Customer
    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(1, "John", "john@example.com");

        customerRepository.addCustomer(customer);

        List<Customer> customers = customerRepository.getAllCustomers();
        assertEquals(1, customers.size());
        assertEquals("John", customers.get(0).getName());
    }

    // Test Get Customer by ID
    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer(2, "Alice", "alice@example.com");
        customerRepository.addCustomer(customer);

        Customer result = customerRepository.getCustomerById(2);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
    }

    // Test Update Customer
    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer(3, "Bob", "bob@example.com");
        customerRepository.addCustomer(customer);

        Customer updatedCustomer = new Customer(3, "Bob Updated", "bob.updated@example.com");
        customerRepository.updateCustomer(updatedCustomer);

        Customer result = customerRepository.getCustomerById(3);

        assertEquals("Bob Updated", result.getName());
        assertEquals("bob.updated@example.com", result.getEmail());
    }

    // Test Delete Customer
    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer(4, "Charlie", "charlie@example.com");
        customerRepository.addCustomer(customer);

        customerRepository.deleteCustomer(4);

        Customer result = customerRepository.getCustomerById(4);
        assertNull(result);
        assertTrue(customerRepository.getAllCustomers().isEmpty());
    }
}
