package com.example.customermgsystem.serviceimpl;

import com.example.customermgsystem.exceptions.CustomerNotFoundException;
import com.example.customermgsystem.models.BillingDetails;
import com.example.customermgsystem.models.Customer;
import com.example.customermgsystem.repository.BillingDetailsRepository;
import com.example.customermgsystem.repository.CustomerRepository;
import com.example.customermgsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
public class CustomerServiceImpl  implements CustomerService {
    private final CustomerRepository customerRepository;
    private final BillingDetailsRepository billingDetailsRepository;
      @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, BillingDetailsRepository billingDetailsRepository) {
        this.customerRepository = customerRepository;
          this.billingDetailsRepository = billingDetailsRepository;
      }

    @Override
    @Transactional
    public Customer addCustomer(Customer customer) {
          Customer customer1 =  customerRepository.findCustomerByEmail(customer.getEmail()) ;
          if(customer1==null) {
              Customer customer2 = new Customer();
              customer2.setFirstName(customer.getFirstName());
              customer2.setLastName(customer.getLastName());
              customer2.setEmail(customer.getEmail());
              BillingDetails billingDetails = new BillingDetails();
              billingDetails.setAccountNumber(generateAccountNumber());
              BillingDetails billingDetails1 = billingDetailsRepository.save(billingDetails);
              customer2.setBillingDetails(billingDetails1);
              ;
              return customerRepository.save(customer2);
          }else{
              throw new  IllegalArgumentException("Customer Already Exists");
          }

    }

    @Override
    public List<Customer> displayAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerByEmail(String email) {
          Customer customer = customerRepository.findCustomerByEmail(email);
          if(!(customer==null)){
              return customer;
        }else{
              throw new CustomerNotFoundException("This customer does not exist");
          }

    }
    public String generateAccountNumber(){
           String lastDigit = "-01";
           int charLength = 7;
        return String.valueOf(new Random()
                        .nextInt(9 * (int) Math.pow(10, charLength - 1) - 1)
                        + (int) Math.pow(10, charLength - 1)) + lastDigit;
    }
}
