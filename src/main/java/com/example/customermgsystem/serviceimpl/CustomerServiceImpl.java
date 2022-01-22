package com.example.customermgsystem.serviceimpl;

import com.example.customermgsystem.models.Customer;
import com.example.customermgsystem.repository.CustomerRepository;
import com.example.customermgsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl  implements CustomerService {
    private final CustomerRepository customerRepository;
      @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setEmail(customer.getEmail());
        customer.setBillingDetails(customer.getBillingDetails());
        return  customerRepository.save(customer);
    }

    @Override
    public List<Customer> displayAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return  customerRepository.findCustomerByEmail(email);
    }
}
