package com.example.customermgsystem.services;

import com.example.customermgsystem.models.Customer;

import java.util.List;

public interface CustomerService {
   Customer addCustomer(Customer customer);
   List<Customer> displayAllCustomers();
   Customer findCustomerByEmail(String email);


}
