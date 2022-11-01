package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.ArticleDto;

public interface IArticle {
    ArticleDto findById(String id);
}
