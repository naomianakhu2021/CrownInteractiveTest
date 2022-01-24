package com.example.customermgsystem.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true,length = 10)
    private  String accountNumber ;
     private  String tarriff;

     @OneToOne
     private Customer customer;
}
