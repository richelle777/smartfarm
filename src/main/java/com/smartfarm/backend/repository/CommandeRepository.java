package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.model.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande,String> {
    Optional<Commande> findCommandeById(String id);
}
