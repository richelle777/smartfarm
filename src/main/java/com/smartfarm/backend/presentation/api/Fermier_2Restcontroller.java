package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.*;
import com.smartfarm.backend.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/fermier2")
@Slf4j
public class Fermier_2Restcontroller {

    @Autowired
    private ICommande iCommande;

    @Autowired
    private IFermier iFermier;

    @Autowired
    private ILivraison iLivraison;

    @Autowired
    private ILocalisation iLocalisation;

    @Autowired
    private ICommandearticle iCommandearticle;

    @PostMapping(value = "/localisation/save")
    public void saveLocalisation(@RequestBody LocalisationDto localisationDto) {
        Fermier_2Restcontroller.log.info("Enregistrement - Localisation");
        iLocalisation.saveLocalisation(localisationDto);
    }

    @PostMapping(value = "/commande/{id}/update/{state}")
    public void updateStatutCommande(@PathVariable String id, @PathVariable String state) {
        Fermier_2Restcontroller.log.info("Mise à jour - Statut de la commande : " + id);
        iCommande.updateStatutCommande(id, state);
    }

    @GetMapping("/fermier/{id}/data")
    public ResponseEntity<FermierDto> getFermierById(@PathVariable String id) {
        Fermier_2Restcontroller.log.info("Lecture - Fermier : " + id);
        return ResponseEntity.ok(iFermier.findFermierById(id));
    }

    @GetMapping("/livraison/list")
    public ResponseEntity<List<LivraisonDto>> listLivraison() {
        Fermier_2Restcontroller.log.info("Liste - livraison");
        return ResponseEntity.ok(iLivraison.listLivraison());
    }

    @GetMapping("/livraison/list/{filter}")
    public ResponseEntity<List<LivraisonDto>> getListByStatutLivraison(@PathVariable String filter) {
        Fermier_2Restcontroller.log.info("Liste - Livraison filté par : " + filter);
        return ResponseEntity.ok(iLivraison.findLivraisonByStatut(filter));
    }

    @GetMapping("/livraison/{id}")
    public ResponseEntity<LivraisonDto> getLivraisonById(@PathVariable String id) {
        Fermier_2Restcontroller.log.info("Lecture - Livraison : " + id);
        return ResponseEntity.ok(iLivraison.findLivraisonById(id));
    }

    @PostMapping(value = "/fermier/{id}/update")
    public void updateFermier(@PathVariable String id) {
        Fermier_2Restcontroller.log.info("Mise à jour - Fermier : " + id);
        FermierDto fermierDto = iFermier.findFermierById(id);
        iFermier.updateFermier(fermierDto);
    }

    @GetMapping("/commandearticle/commande/{id}/data")
    public ResponseEntity<List<Produit>> getListArticleByCommande(@PathVariable String id) {
        Fermier_2Restcontroller.log.info("Les artiles de la commande : " + id);
        return ResponseEntity.ok(iCommandearticle.listArticleByCommande(id));
    }

    @GetMapping("/customer/{id}/commande/history")
    public ResponseEntity<Map<CommandeDto, List<Produit>>> getHistoriqueCommandeCustomer(@PathVariable String id) {
        Fermier_2Restcontroller.log.info("Historique des commandes de l'user id : " + id);
        return ResponseEntity.ok(iCommande.historiqueCommandeClient(id));
    }
}
