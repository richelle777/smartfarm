package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.model.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie,String> {
    Optional<Categorie> findCategorieByNom(String nom);
//    Optional<Article> findById(String id);
}
