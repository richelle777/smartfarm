package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.*;
import com.smartfarm.backend.service.ICommande;
import com.smartfarm.backend.service.ICustomer;
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
    private ICustomer iCustomer;


    @Autowired
    private ILocalisation iLocalisation;

    @CrossOrigin("*")
    @GetMapping("/{id}/commande/history")
    public ResponseEntity<Map<CommandeDto, List<Produit>>> getHistoriqueCommandeCustomer(@PathVariable String id) {
        CustomerRestController.log.info("Historique des commandes de l'user id : " + id);
        return ResponseEntity.ok(iCommande.historiqueCommandeClient(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(iCustomer.listCustomers());
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

    @PostMapping(value = "/update")
    public CustomerDto update(@RequestBody CustomerDto create){
        CustomerRestController.log.info("modifier-client");
        return iCustomer.updateCustomer(create);
    }

    @GetMapping("infos/{email}")
    public ResponseEntity<CustomerDto> getInfoUsers(@PathVariable String email) {
        CustomerRestController.log.info(" vous recuperez les infos du user ayant pour email :" + email);
        return ResponseEntity.ok(iCustomer.findbyEmail(email));
    }
}
