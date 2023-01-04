package com.smartfarm.backend.service;


import com.smartfarm.backend.model.dto.CommandeDto;
import java.util.List;

public interface ICommande {
    List<CommandeDto> listCommandes();
    CommandeDto searchArticleById(String id);
    int deleteCommandeById(String id);
    String saveCommande(CommandeDto commandeDto);
    CommandeDto updateStatutCommande(String id ,String state);

}
