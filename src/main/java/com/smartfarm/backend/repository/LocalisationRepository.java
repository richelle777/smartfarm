package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocalisationRepository extends JpaRepository<Localisation, String> {
    Optional<Localisation> findById(String id);

    @Query(value = "SELECT * FROM `localisation` where localisation.added_by = :iduser" , nativeQuery = true)
    List<Localisation> findByAdded_by(@Param("iduser") String iduser);
}