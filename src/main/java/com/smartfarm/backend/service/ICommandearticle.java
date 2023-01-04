package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.Produit;

import java.util.List;

public interface ICommandearticle {
    List<Produit> listArticleByCommande(String id);
}
