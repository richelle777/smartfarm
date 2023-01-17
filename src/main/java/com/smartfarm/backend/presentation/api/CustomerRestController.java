package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.*;
import com.smartfarm.backend.model.entities.Customer;
import com.smartfarm.backend.service.ICommande;
import com.smartfarm.backend.service.ICustomer;
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
    private ICustomer iCustomer;

    @CrossOrigin("*")
    @GetMapping("/{id}/commande/history")
    public ResponseEntity<Map<CommandeDto, List<Produit>>> getHistoriqueCommandeCustomer(@PathVariable String id) {
        CustomerRestController.log.info("Historique des commandes de l'user id : " + id);
        return ResponseEntity.ok(iCommande.historiqueCommandeClient(id));
    }

    @CrossOrigin("*")
    @PostMapping(value = "/createaccount")
    public ResponseEntity<?> createAccount(@RequestBody CustomerDto customerDto) {
        CustomerRestController.log.info("Création d'un compte public");
        System.out.println(customerDto);
        return ResponseEntity.ok(iCustomer.save(customerDto));
    }

    @CrossOrigin("*")
    @PostMapping(value = "/signin")
    public ResponseEntity<?> authentification(@RequestBody ConnexionForm connexionForm) {
        System.out.println(connexionForm);
        CustomerRestController.log.info("Connexion au compte public d'email : " + connexionForm.getEmail());
        System.out.println(iCustomer.authentification(connexionForm));
        return ResponseEntity.ok(iCustomer.authentification(connexionForm));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(iCustomer.listCustomers());
    }
}
