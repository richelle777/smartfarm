package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.service.IArticle;
import com.smartfarm.backend.service.ICommande;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
@Slf4j
public class CommandeRestController {
    @Autowired
    private ICommande iCommande;

    @GetMapping("/all")
    public ResponseEntity<List<CommandeDto>> getAllCommandes() {

        System.out.println(iCommande.listCommandes());
        return ResponseEntity.ok(iCommande.listCommandes());
    }

    @PostMapping(value = "/save")
    public void enregistrer(@RequestBody CommandeDto create){
        System.out.println(create);
        CommandeRestController.log.info("enregistrer-une-commande");
        iCommande.saveCommande(create);
    }

}
