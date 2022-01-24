package com.example.customermgsystem.models;

import lombok.*;
import org.intellij.lang.annotations.Pattern;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique=true,nullable = false)
    @Email
    private String email;

    @OneToOne
    private  BillingDetails billingDetails;

}
