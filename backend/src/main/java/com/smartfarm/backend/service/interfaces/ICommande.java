package com.smartfarm.backend.service.interfaces;

import com.smartfarm.backend.model.dto.CommandeDto;

public interface ICommande {
    CommandeDto updateStatutCommande(String id ,String state);
}
