package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.service.IArticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthentifPublicRestController {
//    @Autowired
//    private IArticle iArticle;
//    @GetMapping("/all")
//    public ResponseEntity<List<ArticleDto>> getAllArticles() {
//        return ResponseEntity.ok(iArticle.listArticles());
//    }
}
