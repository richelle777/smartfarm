package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.dto.LocalisationDto;
import com.smartfarm.backend.model.dto.Produit;
import com.smartfarm.backend.service.ICommande;
import com.smartfarm.backend.service.ILocalisation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/customer")
@Slf4j
public class CustomerRestController {

    @Autowired
    private ICommande iCommande;

    @Autowired
    private ILocalisation iLocalisation;

    @GetMapping("/{id}/commande/history")
    public ResponseEntity<Map<CommandeDto, List<Produit>>> getHistoriqueCommandeCustomer(@PathVariable String id) {
        CustomerRestController.log.info("Historique des commandes de l'user id : " + id);
        return ResponseEntity.ok(iCommande.historiqueCommandeClient(id));
    }
    @GetMapping("localisation/user/{id}")
    public ResponseEntity<List<LocalisationDto>> listLocalisationUser(@PathVariable String id) {
        CustomerRestController.log.info("Historique des localisations de l'user id : " + id);
        return ResponseEntity.ok(iLocalisation.getLocalisationUser(id));
    }

    @GetMapping("localisation/hide/{id}")
    public ResponseEntity<String> hideLocalisation(@PathVariable String id) {
        CustomerRestController.log.info("cacher a l'utilisateur la localisation id :" +id);
        return ResponseEntity.ok(iLocalisation.hideLocalisation(id));
    }
}
