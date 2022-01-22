package com.example.customermgsystem;

import com.example.customermgsystem.models.Customer;
import com.example.customermgsystem.repository.CustomerRepository;
import com.example.customermgsystem.serviceimpl.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
   @InjectMocks
    private CustomerServiceImpl customerService;
   @Test
    void shouldReturnAllCustomersSuccessfully(){
      Customer customer = new Customer();
      Customer customer1 = new Customer();
      List<Customer> listOfCustomers = new ArrayList<>();
      listOfCustomers.add(customer);
      listOfCustomers.add(customer1);
       Mockito.when(customerRepository.findAll()).thenReturn(listOfCustomers);
       List<Customer>fetchedCustomer =customerRepository.findAll();
       Assertions.assertEquals(2,fetchedCustomer.size());

   }

}
