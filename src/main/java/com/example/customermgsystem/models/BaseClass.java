package com.example.customermgsystem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public abstract  class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
}
