package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.ArticleMapper;
import com.smartfarm.backend.mapper.CommandearticleMapper;
import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.Produit;
import com.smartfarm.backend.repository.ArticleRepository;
import com.smartfarm.backend.repository.CommandearticleRepository;
import com.smartfarm.backend.service.IArticle;
import com.smartfarm.backend.service.ICommandearticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommandearticleServiceImpl implements ICommandearticle {

    @Autowired
    CommandearticleRepository commandearticleRepository;

    @Autowired
    CommandearticleMapper commandearticleMapper;

    @Autowired
    IArticle iArticle;


    @Override
    public List<Produit> listArticleByCommande(String id) {
        return commandearticleRepository.findByIdIdCommande(id).get().stream()
                .map(commandearticle -> {
                    Produit produit = new Produit();
                    produit.setArticleDto(iArticle.findById(commandearticle.getId().getIdArticle()));
                    produit.setQuantity(commandearticle.getQuantite());
                    return produit;
                })
                .collect(Collectors.toList());
    }
}
