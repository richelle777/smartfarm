package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Fermier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FermierRepository extends JpaRepository<Fermier, String> {
    Optional<Fermier> findById(String id);
}