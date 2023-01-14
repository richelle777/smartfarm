package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.LocalisationDto;

public interface ILocalisation {
    String save(LocalisationDto localisationDto);
    String update(LocalisationDto localisationDto);
    String delete(String id);
}
