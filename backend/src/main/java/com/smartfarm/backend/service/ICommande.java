package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.CommandeDto;

public interface ICommande {
    CommandeDto updateStatutCommande(String id ,String state);
}
