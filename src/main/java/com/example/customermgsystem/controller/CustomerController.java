package com.example.customermgsystem.controller;

import com.example.customermgsystem.models.Customer;
import com.example.customermgsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
      @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/newCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Customer>> displayAllCustomers(){
        List<Customer> customerList = customerService.displayAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/findCustomer")
    public ResponseEntity<Customer>findCustomer(@PathVariable String email){
      Customer customer = customerService.findCustomerByEmail(email);
      return new ResponseEntity<>(customer,HttpStatus.OK);
    }
}
