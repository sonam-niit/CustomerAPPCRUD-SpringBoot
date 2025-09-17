package com.example.customerapp;

import com.example.customerapp.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // For JSON conversion

    // Test Create Customer
    @Test
    public void testAddCustomer() throws Exception {
        Customer customer = new Customer(1, "John Doe", "john@example.com");

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk())
                .andExpect(content().string("Customer added successfully!"));
    }

    // Test Get All Customers
    @Test
    public void testGetAllCustomers() throws Exception {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // Test Get Customer by ID
    @Test
    public void testGetCustomerById() throws Exception {
        Customer customer = new Customer(2, "Alice", "alice@example.com");

        // Add a customer first
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());

        // Now fetch by ID
        mockMvc.perform(get("/customers/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"))
                .andExpect(jsonPath("$.email").value("alice@example.com"));
    }

    // Test Update Customer
    @Test
    public void testUpdateCustomer() throws Exception {
        Customer customer = new Customer(3, "Bob", "bob@example.com");

        // Add a customer first
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());

        // Update the customer
        Customer updatedCustomer = new Customer(3, "Bob Updated", "bob.updated@example.com");
        mockMvc.perform(put("/customers/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCustomer)))
                .andExpect(status().isOk())
                .andExpect(content().string("Customer updated successfully!"));
    }

    // Test Delete Customer
    @Test
    public void testDeleteCustomer() throws Exception {
        Customer customer = new Customer(4, "Charlie", "charlie@example.com");

        // Add a customer first
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());

        // Delete customer
        mockMvc.perform(delete("/customers/4"))
                .andExpect(status().isOk())
                .andExpect(content().string("Customer deleted successfully!"));
    }
}
