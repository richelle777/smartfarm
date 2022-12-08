package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.dto.Produit;

import java.util.List;
import java.util.Map;

public interface ICommande {
    CommandeDto updateStatutCommande(String id ,String state);
    Map<CommandeDto, List<Produit>> historiqueCommandeClient(String id);
}
