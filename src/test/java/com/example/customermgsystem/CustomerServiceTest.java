package com.example.customermgsystem;

import com.example.customermgsystem.models.BillingDetails;
import com.example.customermgsystem.models.Customer;
import com.example.customermgsystem.repository.BillingDetailsRepository;
import com.example.customermgsystem.repository.CustomerRepository;
import com.example.customermgsystem.serviceimpl.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
    @Mock
    private  BillingDetailsRepository billingDetailsRepository;
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
   @Test
    void  shouldCreateNewCustomer(){
         Customer customer = new Customer();
         customer.setId(1L);
         customer.setEmail("nana@fisher.com");
       BillingDetails billingDetails = new BillingDetails();
         billingDetails.setId(1l);
            Customer customer1 = customerService.addCustomer(customer);
       ArgumentCaptor<Customer>argumentCaptor=ArgumentCaptor.forClass(Customer.class);
               Mockito.verify((customerRepository),Mockito.times(1)).findCustomerByEmail("nana@fisher.com");
        Mockito.verify((customerRepository),Mockito.times(1)).save(argumentCaptor.capture());
   }
}
