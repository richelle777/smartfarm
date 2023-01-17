package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Customer;
import com.smartfarm.backend.model.entities.Fermier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findById(String id);
    @Query(value = "SELECT * FROM `customer` where email = :email" , nativeQuery = true)
    Optional<Customer> findByEmail(@Param("email") String email);

    boolean existsByEmail(String email);
}
