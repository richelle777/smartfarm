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
        CommandeRestController.log.info("Liste des commandes");
        return ResponseEntity.ok(iCommande.listCommandes());
    }

    @PostMapping(value = "/save")
    public void enregistrer(@RequestBody CommandeDto create){
        CommandeRestController.log.info("enregistrer-une-commande");
        iCommande.saveCommande(create);
    }

    @GetMapping("/{id}/update/state/{state}")
    public ResponseEntity<String> updateStateCommande(@PathVariable String id, @PathVariable String state) {
        CommandeRestController.log.info("Mise à jour statut de la commande d'id : " + id);
        return ResponseEntity.ok(iCommande.updateStatut(id, state));
    }

    @GetMapping("/{id}/data")
    public ResponseEntity<CommandeDto> CommandesUser(@PathVariable String id) {
        CommandeRestController.log.info("Lecture de la commande d'id : " + id);
        return ResponseEntity.ok(iCommande.findById(id));
    }
}
