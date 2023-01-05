package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.dto.Produit;
import com.smartfarm.backend.service.ICommande;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/customer")
@Slf4j
public class CustomerRestController {

    @Autowired
    private ICommande iCommande;

//    @GetMapping("/{id}/commande/history")
//    public ResponseEntity<Map<CommandeDto, List<Produit>>> getHistoriqueCommandeCustomer(@PathVariable String id) {
//        CustomerRestController.log.info("Historique des commandes de l'user id : " + id);
//        return ResponseEntity.ok(iCommande.historiqueCommandeClient(id));
//    }
}
