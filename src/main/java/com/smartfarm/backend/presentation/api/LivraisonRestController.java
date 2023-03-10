package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.LivraisonDto;
import com.smartfarm.backend.model.entities.Livraison;
import com.smartfarm.backend.service.ILivraison;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livraison")
@Slf4j
public class LivraisonRestController {

    @Autowired
    private ILivraison iLivraison;

    @GetMapping("/list")
    public ResponseEntity<List<LivraisonDto>> listLivraison() {
        LivraisonRestController.log.info("Liste - livraison");
        return ResponseEntity.ok(iLivraison.listLivraison());
    }

    @GetMapping("/list/{filter}")
    public ResponseEntity<List<LivraisonDto>> getListByStatutLivraison(@PathVariable String filter) {
        LivraisonRestController.log.info("Liste - Livraison filté par : " + filter);
        return ResponseEntity.ok(iLivraison.findLivraisonByStatut(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivraisonDto> getDeliveryById(@PathVariable String id) {
        LivraisonRestController.log.info("Affiche  - Statut de la livraison : " + id);
        return ResponseEntity.ok(iLivraison.findLivraisonById(id));
    }

    @GetMapping("/{id}/update/state/{state}")
    public ResponseEntity<String> updateStateDelivery(@PathVariable String id, @PathVariable String state) {
        LivraisonRestController.log.info("Mise à jour du statut de la livraison d'Id : " + id);
        return ResponseEntity.ok(iLivraison.updateOrderDelivery(id, state));
    }

    @CrossOrigin("*")
    @PostMapping("/save")
    public ResponseEntity<String> createLivraison(@RequestBody LivraisonDto create) {
        LivraisonRestController.log.info("Mise à jour du statut de la livraison d'Id : " + create);
        return ResponseEntity.ok(iLivraison.save(create));
    }



}
