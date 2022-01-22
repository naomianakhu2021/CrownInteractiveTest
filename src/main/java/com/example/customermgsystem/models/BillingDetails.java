package com.example.customermgsystem.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BillingDetails {
    @Id
    @Column( nullable = false)
    private Long id;
    @Column(unique=true,length = 10)
    private  String accountNumber ;
     private  String tarriff;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn( name= "customer_id",nullable = false)
     private Customer customer;
}
