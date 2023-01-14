package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.LivraisonDto;
import com.smartfarm.backend.model.entities.Livraison;

import java.util.List;

public interface ILivraison {
    List<LivraisonDto> listLivraison();
    LivraisonDto findLivraisonById(String id);
    List<LivraisonDto> findLivraisonByStatut(String state);
    String updateOrderDelivery(String id, String state);
}
