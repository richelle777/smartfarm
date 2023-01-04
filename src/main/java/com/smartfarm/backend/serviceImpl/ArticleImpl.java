package com.smartfarm.backend.serviceImpl;


import com.smartfarm.backend.mapper.ArticleMapper;
import com.smartfarm.backend.mapper.CategorieMapper;
import com.smartfarm.backend.mapper.ImageMapper;
import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.repository.ArticleRepository;
import com.smartfarm.backend.service.IArticle;
import com.smartfarm.backend.service.IFermier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleImpl implements IArticle {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CategorieMapper categorieMapper;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    IFermier iFermier;


    @Override
    public ArticleDto findById(String id) {
        Article article = articleRepository.findById(id).get();
        ArticleDto articleDto = articleMapper.toDto(article);
        articleDto.setCategorieDto(categorieMapper.toDto(article.getCategorie()));
        articleDto.setImageDto(imageMapper.toDto(article.getImage()));
        articleDto.setFermierDto(iFermier.findFermierById(article.getFermier().getId()));
        return articleDto;
    }
}
