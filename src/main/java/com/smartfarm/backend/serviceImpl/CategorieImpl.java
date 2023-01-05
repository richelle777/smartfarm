package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.CategorieMapper;
import com.smartfarm.backend.model.dto.CategorieDto;
import com.smartfarm.backend.repository.ArticleRepository;
import com.smartfarm.backend.repository.CategorieRepository;
import com.smartfarm.backend.service.ICategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieImpl implements ICategorie {
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    CategorieMapper categorieMapper;


    @Override
    public List<CategorieDto> listCategories() {
        return categorieRepository.findAll().stream().map(categorie -> categorieMapper.toDto(categorie)).collect(Collectors.toList());
    }

    @Override
    public CategorieDto searchCategorieDtoByNom(String nom) {
        return categorieMapper.toDto(categorieRepository.findCategorieByNom(nom).get());
    }
}
