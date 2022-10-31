package com.smartfarm.backend.service.interfaces;

import com.smartfarm.backend.model.dto.LivraisonDto;
import com.smartfarm.backend.model.entities.Livraison;

import java.util.List;

public interface ILivraison {
    List<LivraisonDto> listLivraison();
    LivraisonDto findLivraisonById(String id);
    List<LivraisonDto> findLivraisonByStatut(String state);
    LivraisonDto updateOrderDelivery(LivraisonDto livraisonDto, String state);
}
