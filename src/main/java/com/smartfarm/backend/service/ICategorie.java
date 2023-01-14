package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.CategorieDto;

import java.util.List;

public interface ICategorie {
    List<CategorieDto> listCategories();
}
