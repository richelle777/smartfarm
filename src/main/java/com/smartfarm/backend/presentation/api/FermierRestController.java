package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.ConnexionForm;
import com.smartfarm.backend.model.dto.FermierDto;
import com.smartfarm.backend.model.dto.LocalisationDto;
import com.smartfarm.backend.service.IFermier;
import com.smartfarm.backend.service.ILocalisation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/fermier")
@Slf4j
public class FermierRestController {

    @Autowired
    private IFermier iFermier;


    @PostMapping(value = "/save/localisation")
    public void saveLocalisation(@RequestBody LocalisationDto localisationDto) {
        FermierRestController.log.info("Enregistrement - Localisation");
        iFermier.saveLocalisation(localisationDto);
    }

    @GetMapping("/{id}/data")
    public ResponseEntity<FermierDto> getFermierById(@PathVariable String id) {
        FermierRestController.log.info("Lecture - Fermier : " + id);
        return ResponseEntity.ok(iFermier.findFermierById(id));
    }

    @PostMapping(value = "/{id}/update")
    public ResponseEntity<String> updateFermier(@PathVariable String id, @RequestBody FermierDto fermierDto) {
        FermierRestController.log.info("Mise à jour - Fermier : " + id);
        return ResponseEntity.ok(iFermier.updateFermier(fermierDto));
    }

    @PostMapping(value = "/createaccount")
    public ResponseEntity<String> createAccount(@RequestBody FermierDto fermierDto) {
        FermierRestController.log.info("Création d'un compte fermier");
        return ResponseEntity.ok(iFermier.save(fermierDto));
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<String> authentification(@RequestBody ConnexionForm connexionForm) {
        FermierRestController.log.info("Connexion au compte fermier d'email : " + connexionForm.getEmail());
        return ResponseEntity.ok(iFermier.authentification(connexionForm));
    }
}
