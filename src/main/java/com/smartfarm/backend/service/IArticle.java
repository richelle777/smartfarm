package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.InfoCommande;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IArticle {
    List<ArticleDto> listArticles();
    List<ArticleDto> searchArticlesBYCategorie(String category);
    ArticleDto findById(String id);
    String save(String articleDto, MultipartFile file) throws IOException;
    String update(String articleDto, MultipartFile file) throws IOException;
    String delete(String id);
    List<ArticleDto> listArticlesByIdFermier(String idFermier);
    Map<ArticleDto, List<InfoCommande>> listCommandesArticle(String idFarmer);
}
