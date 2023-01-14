package com.smartfarm.backend.repository;
import com.smartfarm.backend.model.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
public interface ArticleRepository extends JpaRepository<Article,String>{
    Optional<Article> findArticleByNom(String nom);
    @Query(value = "SELECT id_article,article.nom,article.descript,prixU,article.id_categorie,id_fermier ,id_image , qte FROM `article` INNER JOIN `categorie` ON article.id_categorie=categorie.id_categorie  where categorie.nom = :category" , nativeQuery = true)
    List<Article> findArticleByCategorie(@Param("category") String category);
    Optional<List<Article>> findArticleByNomOrDescription(String motcle1, String motcle2);
    Optional<Article> findById(String id);
}
