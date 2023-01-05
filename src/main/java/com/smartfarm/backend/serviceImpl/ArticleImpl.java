package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.*;
import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.ArticleDtoForList;
import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.service.IFermier;
import lombok.extern.slf4j.Slf4j;
import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.model.entities.Commande;
import com.smartfarm.backend.repository.ArticleRepository;
import com.smartfarm.backend.service.IArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ArticleImpl implements IArticle{
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleForListMapper articleForListMapper;
    @Autowired
    CategorieMapper categorieMapper;
    @Autowired
    ImageMapper imageMapper;
    @Autowired
    FermierMapper fermierMapper;
    @Autowired
    IFermier iFermier;

    @Override
    public Article findByNumber(Integer number) {
        return null;
    }

    @Override
    public void deleteByNumber(Integer number) {

    }

    @Override
    public List<ArticleDto> listArticles() {
//        List<ArticleDtoForList> articleDtos = articleRepository.findAll().stream().map(article ->{
//            System.out.println(article);
//            ArticleDtoForList articleDto = articleForListMapper.toDto(article);
//            System.out.println(articleDto);
////            articleDto.setCategorieDto(categorieMapper.toDto(article.getCategorie()));
////            articleDto.setFermierDto(fermierMapper.toDto(article.getFermier()));
//            articleDto.setImageDto(imageMapper.toDto(article.getImage()));
//            return articleDto;
//        }).collect(Collectors.toList());
//        System.out.println(articleDtos);
//        return articleDtos;
        List<ArticleDto> articleDtos = articleRepository.findAll().stream().map(article ->{
            System.out.println(article);
            ArticleDto articleDto = articleMapper.toDto(article);
            System.out.println(articleDto);
//            articleDto.setCategorieDto(categorieMapper.toDto(article.getCategorie()));
//            articleDto.setFermierDto(fermierMapper.toDto(article.getFermier()));
            articleDto.setImageDto(imageMapper.toDto(article.getImage()));
            return articleDto;
        }).collect(Collectors.toList());
        System.out.println(articleDtos);
        return articleDtos;
    }


    @Override
    public ArticleDtoForList searchArticleByNom(String nom) {
        Article article = articleRepository.findArticleByNom(nom).get();
        ArticleDtoForList articleDto = articleForListMapper.toDto(article);
        articleDto.setImageDto(imageMapper.toDto(articleRepository.findArticleByNom(nom).get().getImage()));
        return articleDto;
    }

    @Override
    public List<ArticleDtoForList> searchArticlesBYkeyword(String keyword) {

        List<ArticleDtoForList> articleDtos = articleRepository.findArticleByNomOrDescription(keyword , keyword).get().stream().map(article ->{
            ArticleDtoForList articleDto = articleForListMapper.toDto(article);
            articleDto.setImageDto(imageMapper.toDto(article.getImage()));
            return articleDto;
        }).collect(Collectors.toList());
        return articleDtos;
    }

    @Override
    public List<ArticleDtoForList> searchArticlesBYCategorie(String category) {
        List<ArticleDtoForList> articleDtos = articleRepository.findArticleByCategorie(category).stream().map(article ->{
            ArticleDtoForList articleDto = articleForListMapper.toDto(article);
            articleDto.setImageDto(imageMapper.toDto(article.getImage()));
            return articleDto;
        }).collect(Collectors.toList());
        return articleDtos;
    }

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
