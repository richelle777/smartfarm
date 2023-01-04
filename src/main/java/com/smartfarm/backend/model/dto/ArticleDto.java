package com.smartfarm.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleDto {
    private String id;
    private String nom;
    private String description;
    private Integer prixU;
    private Integer quantite;
    private CategorieDto categorieDto;
    private ImageDto imageDto;
    private FermierDto fermierDto;
}
