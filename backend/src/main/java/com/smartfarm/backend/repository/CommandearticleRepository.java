package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Commandearticle;
import com.smartfarm.backend.model.entities.CommandearticleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandearticleRepository extends JpaRepository<Commandearticle, CommandearticleId> {
    Optional<List<Commandearticle>> findByIdIdCommande(String id);
}
