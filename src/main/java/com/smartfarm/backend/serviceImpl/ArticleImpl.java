package com.smartfarm.backend.serviceImpl;

import com.google.gson.Gson;
import com.smartfarm.backend.mapper.*;
import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.ImageDto;
import com.smartfarm.backend.service.Iimage;
import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.repository.ArticleRepository;
import com.smartfarm.backend.service.IArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ArticleImpl implements IArticle{
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    Iimage iimage;


    @Override
    public List<ArticleDto> listArticles() {
        List<ArticleDto> articleDtos = articleRepository.findAll().stream().map(article ->{
            ArticleDto articleDto = articleMapper.toDto(article);
<<<<<<< Updated upstream
            System.out.println(articleDto);
            articleDto.setCategorieDto(categorieMapper.toDto(article.getCategorie()));
            articleDto.setFermierDto(fermierMapper.toDto(article.getFermier()));
            articleDto.setImageDto(imageMapper.toDto(article.getImage()));
=======
>>>>>>> Stashed changes
            return articleDto;
        }).collect(Collectors.toList());
        return articleDtos;
    }

    @Override
    public List<ArticleDto> searchArticlesBYCategorie(String category) {
        List<ArticleDto> articleDtos = articleRepository.findArticleByCategorie(category).stream().map(article ->{
            ArticleDto articleDto = articleMapper.toDto(article);
            return articleDto;
        }).collect(Collectors.toList());
        return articleDtos;
    }

    @Override
    public ArticleDto findById(String id) {
        Article article = articleRepository.findById(id).get();
        ArticleDto articleDto = articleMapper.toDto(article);
        return articleDto;
    }

    @Override
    @Transactional
    public String save(String string, MultipartFile file) throws IOException {
        //Save image in database
        ImageDto imageDto = iimage.store(file);

        // Transform json to articleDto
        Gson gson = new Gson();
        ArticleDto articleDto = gson.fromJson(string, ArticleDto.class);

        //set image and tranform to entity
        articleDto.setImageDto(imageDto);
        Article article = articleMapper.toEntity(articleDto);

        //Function to create a new id for the article
        Boolean isIdNotNew = true;
        String id = "";
        while (isIdNotNew){
            long code = Math.round(Math.random()* 10000);
            id = "AR" + code;
            if (!articleRepository.existsById(id))
                isIdNotNew = false;
        }
        article.setId(id);
        return "Nouvel article enregistré avec l'id : " + articleRepository.save(article).getId();
    }

    @Override
<<<<<<< Updated upstream
    public List<ArticleDtoForList> searchArticlesBYCategorie(String category) {
        List<ArticleDtoForList> articleDtos = articleRepository.findArticleByCategorie(category).stream().map(article ->{
            ArticleDtoForList articleDto = articleForListMapper.toDto(article);
            articleDto.setImageDto(imageMapper.toDto(article.getImage()));
            return articleDto;
        }).collect(Collectors.toList());
        return articleDtos;
=======
    public String update(String string, MultipartFile file) throws IOException {
        // Transform json to articleDto
        Gson gson = new Gson();
        ArticleDto articleDto = gson.fromJson(string, ArticleDto.class);

        //Update image
        ImageDto imageDto = iimage.update(file, articleDto.getImageDto().getId());

        //Update article
        Article article = articleRepository.findById(articleDto.getId()).get();
        articleMapper.copy(articleDto, article);
        return "Mise à jour effectué avec succés";
>>>>>>> Stashed changes
    }

    @Override
    public String delete(String id) {
        if(articleRepository.existsById(id)){
            Article article = articleRepository.findById(id).get();
            articleRepository.delete(article);
            return "Suppression effectué avec succés.";
        }
        return "Erreur suppression : Id spécifié non-trouvé.";
    }
}
