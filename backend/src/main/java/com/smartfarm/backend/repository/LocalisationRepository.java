package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalisationRepository extends JpaRepository<Localisation, String> {
    Optional<Localisation> findById(String id);
}