package com.smartfarm.backend.service.interfaces;

import com.smartfarm.backend.model.dto.LocalisationDto;

public interface ILocalisation {
    String saveLocalisation(LocalisationDto localisationDto);
    LocalisationDto updateLocalisation(LocalisationDto localisationDto);
    void deleteLocalisation(LocalisationDto localisationDto);
}
