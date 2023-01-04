package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.ArticleDtoForList;
import com.smartfarm.backend.model.dto.CommandearticleDto;
import com.smartfarm.backend.service.IArticle;
import com.smartfarm.backend.service.ICommande;
import com.smartfarm.backend.service.ICommandearticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/commandearticle")
@Slf4j
public class CommandeArticleRestController {
    @Autowired
    private ICommandearticle iCommandearticle;

    @GetMapping("/all")
    public ResponseEntity<List<CommandearticleDto>> getAllCommandeArticles() {
        return ResponseEntity.ok(iCommandearticle.listCommandeArticles());
    }

    @PostMapping(value = "/save")
    public void enregistrer(@RequestBody CommandearticleDto create){
        //ArticleRestController.log.info("enregistrer-commande");
        iCommandearticle.saveCommandeArticle(create);
    }

    @GetMapping("/{id}/delete")
    public int deteleCommandeArticle(@PathVariable String id){
        return iCommandearticle.deleteCommandeArticleById(id);
    }

    @GetMapping("/{qte}/{id}/update")
    public int updateCommandeArticle(@P
                                                 Integer qte, @PathVariable String id){
        return iCommandearticle.UpdateCommandeArticle(qte, id);
    }
}
