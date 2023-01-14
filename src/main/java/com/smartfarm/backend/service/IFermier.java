package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.ConnexionForm;
import com.smartfarm.backend.model.dto.FermierDto;
import com.smartfarm.backend.model.dto.LocalisationDto;

public interface IFermier {
    FermierDto findFermierById(String id);
    String updateFermier(FermierDto fermierDto);
    String saveLocalisation(LocalisationDto localisationDto);
    String save(FermierDto fermierDto);
    String authentification(ConnexionForm connexionForm);
}
