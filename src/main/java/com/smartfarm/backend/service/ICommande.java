package com.smartfarm.backend.service;


import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.dto.Produit;

import java.util.List;
import java.util.Map;

public interface ICommande {
    List<CommandeDto> listCommandes();
    CommandeDto findById(String id);
    String deleteById(String id);
    String saveCommande(CommandeDto commandeDto);
    String updateStatut(String id, String state);
    Map<CommandeDto, List<Produit>> historiqueCommandeClient(String id);
    List<CommandeDto> listCommandesClient(String id);
}
