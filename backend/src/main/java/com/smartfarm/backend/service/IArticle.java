package com.smartfarm.backend.service;

import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.model.dto.ArticleDto;
import java.util.List;

public interface IArticle {
    Article findByNumber(Integer number);

    List<ArticleDto> listArticles();

    ArticleDto findByNumberDto(Integer number);

    public void deleteByNumber(Integer number);
}
