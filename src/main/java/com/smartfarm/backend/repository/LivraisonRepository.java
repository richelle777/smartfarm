package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivraisonRepository extends JpaRepository<Livraison, String> {
    Optional<Livraison> findById(String id);
    Optional<List<Livraison>> findByStatutLivraison(String state);
}
