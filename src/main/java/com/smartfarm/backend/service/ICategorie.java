package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.ArticleDtoForList;
import com.smartfarm.backend.model.dto.CategorieDto;
import com.smartfarm.backend.model.entities.Categorie;

import java.util.List;

public interface ICategorie {

    List<CategorieDto> listCategories();
    CategorieDto searchCategorieDtoByNom(String nom);

}
