package com.smartfarm.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MapArticleCommande {
    private ArticleDto articleDto;
    private List<InfoCommande> infoCommandes;
}
