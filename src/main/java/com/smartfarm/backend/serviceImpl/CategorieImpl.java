package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.CategorieMapper;
import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.CategorieDto;
import com.smartfarm.backend.model.entities.Article;
import com.smartfarm.backend.model.entities.Categorie;
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
        List<CategorieDto> categorieDtos = categorieRepository.findAll().stream().map(categorie ->{
            Article article;
            System.out.println(categorie);
            CategorieDto categorieDto = categorieMapper.toDto(categorie);
            System.out.println(categorieDto);
               return categorieDto;
        }).collect(Collectors.toList());
        return categorieDtos;
    }

    @Override
    public CategorieDto searchCategorieDtoByNom(String nom) {
        return categorieMapper.toDto(categorieRepository.findCategorieByNom(nom).get());
    }
}
