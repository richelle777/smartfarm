package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.CategorieMapper;
import com.smartfarm.backend.model.dto.CategorieDto;
import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.repository.CategoryRepository;
import com.smartfarm.backend.service.ICategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieImpl implements ICategorie {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategorieMapper categorieMapper;


    @Override
    public List<CategorieDto> listCategories() {
        List<CategorieDto> categorieDtos = categoryRepository.findAll().stream().map(categorie ->{
            CategorieDto categorieDto = categorieMapper.toDto(categorie);
            return categorieDto;
        }).collect(Collectors.toList());
        return categorieDtos;
    }
}
