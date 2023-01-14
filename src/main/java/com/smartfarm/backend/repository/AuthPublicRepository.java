package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthPublicRepository extends JpaRepository<Customer,String> {
    Customer findByEmail(String email);
    Customer findByUsername(String username);
}
