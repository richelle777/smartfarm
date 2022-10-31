package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande, String> {
    Optional<Commande> findById(String id);
}
