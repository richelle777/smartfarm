package com.smartfarm.backend.repository;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.CommandearticleDto;
import com.smartfarm.backend.model.entities.Commandearticle;
import com.smartfarm.backend.model.entities.CommandearticleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommandearticleRepository extends JpaRepository<Commandearticle, CommandearticleId> {

    Optional<List<Commandearticle>> findByIdIdCommande(String id);
    @Modifying
    @Query(value = "DELETE FROM `commandearticle` where commandearticle.id_article = :idCommande" , nativeQuery = true)
    void deleteCommandeArticleById(@Param("idCommande") String idCommande);

    @Modifying
    @Query(value = "UPDATE commandearticle SET commandearticle.quantite = :quantite where commandearticle.id_article = :idCommande" , nativeQuery = true)
    void updateCommandeArticle(@Param("quantite") Integer quantite, @Param("idCommande") String idCommande);

}
