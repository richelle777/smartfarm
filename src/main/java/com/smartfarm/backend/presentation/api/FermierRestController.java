package com.smartfarm.backend.presentation.api;

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

    @Autowired
    private ILocalisation iLocalisation;

    @PostMapping(value = "/localisation/save")
    public void saveLocalisation(@RequestBody LocalisationDto localisationDto) {
        FermierRestController.log.info("Enregistrement - Localisation");
        iLocalisation.saveLocalisation(localisationDto);
    }

    @GetMapping("/{id}/data")
    public ResponseEntity<FermierDto> getFermierById(@PathVariable String id) {
        FermierRestController.log.info("Lecture - Fermier : " + id);
        return ResponseEntity.ok(iFermier.findFermierById(id));
    }

    @PostMapping(value = "/fermier/{id}/update")
    public void updateFermier(@PathVariable String id) {
        FermierRestController.log.info("Mise à jour - Fermier : " + id);
        FermierDto fermierDto = iFermier.findFermierById(id);
        iFermier.updateFermier(fermierDto);
    }
}
