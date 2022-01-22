package com.example.customermgsystem.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "customer_id")
    private long id;
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique=true,nullable = false)
    private String email;

    @OneToOne(mappedBy = "customer",fetch = FetchType.LAZY, optional = false)
     private  BillingDetails billingDetails;

}
