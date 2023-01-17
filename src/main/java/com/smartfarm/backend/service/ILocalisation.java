package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.LocalisationDto;

import java.util.List;

public interface ILocalisation {
    String save(LocalisationDto localisationDto);
    String update(LocalisationDto localisationDto);
    String delete(String id);

    String hideLocalisation(String id);
    List<LocalisationDto> getLocalisationUser(String id);
}
