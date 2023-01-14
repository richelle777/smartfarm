package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.ArticleDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IArticle {
    List<ArticleDto> listArticles();
    List<ArticleDto> searchArticlesBYCategorie(String category);
    ArticleDto findById(String id);
    String save(String articleDto, MultipartFile file) throws IOException;
    String update(String articleDto, MultipartFile file) throws IOException;
    String delete(String id);
}
