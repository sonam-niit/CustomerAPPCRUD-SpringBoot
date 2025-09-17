package com.example.customerapp;

import com.example.customerapp.entity.Customer;
import com.example.customerapp.repository.CustomerRepository;
import com.example.customerapp.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository; // Mock dependency

    @InjectMocks
    private CustomerService customerService; // Service being tested

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    // Test Add Customer
    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(1, "John", "john@example.com");

        customerService.addCustomer(customer);

        // Verify that repository method was called
        verify(customerRepository, times(1)).addCustomer(customer);
    }

    // Test Get All Customers
    @Test
    public void testGetAllCustomers() {
        List<Customer> mockCustomers = Arrays.asList(
                new Customer(1, "Alice", "alice@example.com"),
                new Customer(2, "Bob", "bob@example.com")
        );

        when(customerRepository.getAllCustomers()).thenReturn(mockCustomers);

        List<Customer> result = customerService.getAllCustomers();

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    // Test Get Customer by ID
    @Test
    public void testGetCustomerById() {
        Customer mockCustomer = new Customer(1, "Charlie", "charlie@example.com");

        when(customerRepository.getCustomerById(1)).thenReturn(mockCustomer);

        Customer result = customerService.getCustomerById(1);

        assertNotNull(result);
        assertEquals("Charlie", result.getName());
    }

    // Test Update Customer
    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer(2, "David", "david@example.com");

        customerService.updateCustomer(customer);

        verify(customerRepository, times(1)).updateCustomer(customer);
    }

    // Test Delete Customer
    @Test
    public void testDeleteCustomer() {
        customerService.deleteCustomer(3);

        verify(customerRepository, times(1)).deleteCustomer(3);
    }
}
