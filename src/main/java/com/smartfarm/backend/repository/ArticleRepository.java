package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, String> {
    Optional<Article> findById(String id);
}
