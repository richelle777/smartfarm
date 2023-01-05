package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.LivraisonDto;
import com.smartfarm.backend.service.ILivraison;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<LivraisonDto> getLivraisonById(@PathVariable String id) {
        LivraisonRestController.log.info("Lecture - Livraison : " + id);
        return ResponseEntity.ok(iLivraison.findLivraisonById(id));
    }
}
