package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.ArticleDtoForList;
import com.smartfarm.backend.service.IArticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/article")
@Slf4j
public class ArticleRestController {

    @Autowired
    private IArticle iArticle;

    @GetMapping("/all")
    public ResponseEntity<List<ArticleDtoForList>> getAllArticles() {
        return ResponseEntity.ok(iArticle.listArticles());
    }

    @GetMapping("/{nom}/data")
    public ResponseEntity<ArticleDtoForList> getArticleByNom(@PathVariable String nom){
        return ResponseEntity.ok(iArticle.searchArticleByNom(nom));
    }

//    @GetMapping("/{nom}/dataAll")
//    public ResponseEntity<List<ArticleDtoForList>> getArticleByKeyword(@PathVariable String keyword){
//        return ResponseEntity.ok(iArticle.searchArticlesBYkeyword(keyword));
//    }

    @GetMapping("/{category}/searchByCategorie")
    public  ResponseEntity<List<ArticleDtoForList>> searchArticle(@PathVariable String category){
        return ResponseEntity.ok(iArticle.searchArticlesBYCategorie(category));
    }
}
