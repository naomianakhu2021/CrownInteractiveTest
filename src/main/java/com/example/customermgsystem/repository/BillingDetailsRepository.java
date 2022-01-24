package com.example.customermgsystem.repository;

import com.example.customermgsystem.models.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingDetailsRepository extends JpaRepository<BillingDetails,Long> {

}
