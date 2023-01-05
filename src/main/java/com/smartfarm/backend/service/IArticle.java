package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.ArticleDtoForList;
import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.model.dto.ArticleDto;
import java.util.List;

public interface IArticle {
    Article findByNumber(Integer number);
    public void deleteByNumber(Integer number);
    List<ArticleDto> listArticles();
    ArticleDtoForList searchArticleByNom(String nom);
    List<ArticleDtoForList> searchArticlesBYkeyword(String keyword);
    List<ArticleDtoForList> searchArticlesBYCategorie(String category);
    ArticleDto findById(String id);
}
