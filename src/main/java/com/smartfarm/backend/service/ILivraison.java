package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.LivraisonDto;

import java.util.List;
import java.util.Optional;

public interface ILivraison {
    List<LivraisonDto> listLivraison();

    String save (LivraisonDto livraisonDto);
    LivraisonDto findLivraisonById(String id);
    List<LivraisonDto> findLivraisonByStatut(String state);
    String updateOrderDelivery(String id, String state);
}
