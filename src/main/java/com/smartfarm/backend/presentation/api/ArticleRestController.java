package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.InfoCommande;
import com.smartfarm.backend.model.dto.MapArticleCommande;
import com.smartfarm.backend.service.IArticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/article")
@Slf4j
public class ArticleRestController {

    @Autowired
    private IArticle iArticle;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        return ResponseEntity.ok(iArticle.listArticles());
    }


    @CrossOrigin("*")
    @GetMapping("/fermier/{id}/{idCategory}/searchByCategorie")
    public  ResponseEntity<List<ArticleDto>> searchArticleFermier(@PathVariable String id, @PathVariable String idCategorie){
        return ResponseEntity.ok(iArticle.searchArticlesFermierBYCategorie(id, idCategorie));
    }

    @CrossOrigin("*")
    @GetMapping("/{category}/searchByCategorie")
    public  ResponseEntity<List<ArticleDto>> searchArticle(@PathVariable String category){
        return ResponseEntity.ok(iArticle.searchArticlesBYCategorie(category));
    }

    @CrossOrigin("*")
    @PostMapping(value = "/fermier/{id}/save")
    public ResponseEntity<String> saveArticle(@RequestParam("articleDto") String articleDto, @RequestParam("file") MultipartFile file, @PathVariable String id) throws IOException {
        ArticleRestController.log.info("Enregistrement de l'article");
        return ResponseEntity.ok(iArticle.save(articleDto, file, id));
    }

    @CrossOrigin("*")
    @PostMapping(value = "/update")
    public ResponseEntity<String> updateArticle(@RequestParam("articleDto") String articleDto, @RequestParam("file") MultipartFile file) throws IOException {
        ArticleRestController.log.info("Mise à jour de l'article");
        return ResponseEntity.ok(iArticle.update(articleDto, file));
    }

    @CrossOrigin("*")
    @GetMapping("/{id}/delete")
    public  ResponseEntity<String> deleteArticle(@PathVariable String id){
        ArticleRestController.log.info("Suppréssion de l'article");
        return ResponseEntity.ok(iArticle.delete(id));
    }

    @CrossOrigin("*")
    @GetMapping("/{id}/data")
    public  ResponseEntity<ArticleDto> getArticleById(@PathVariable String id){
        ArticleRestController.log.info("Lecture de l'article d'id : " + id);
        return ResponseEntity.ok(iArticle.findById(id));
    }

    @CrossOrigin("*")
    @GetMapping("/fermier/{id}/all")
    public  ResponseEntity<List<ArticleDto>> getArticlesByIdFermier(@PathVariable String id){
        ArticleRestController.log.info("Collecte des articles du fermier d'id : " + id);
        return ResponseEntity.ok(iArticle.listArticlesByIdFermier(id));
    }

    @CrossOrigin("*")
    @GetMapping("/fermier/{id}/commandes")
    public  ResponseEntity<List<MapArticleCommande>> getCommandesForFermier(@PathVariable String id){
        ArticleRestController.log.info("Collecte des articles du fermier d'id : " + id);
        return ResponseEntity.ok(iArticle.listCommandesArticle(id));
    }
}
