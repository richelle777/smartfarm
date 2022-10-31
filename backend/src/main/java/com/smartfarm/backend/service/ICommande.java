package com.smartfarm.backend.service;

import com.smartfarm.backend.model.entities.Commande;
import com.smartfarm.backend.model.dto.CommandeDto;
import java.util.List;

public interface ICommande {
    Commande findByNumber(Integer nuumber);

}
