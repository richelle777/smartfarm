package com.smartfarm.backend.service;

import com.smartfarm.backend.mapper.LivraisonMapper;
import com.smartfarm.backend.model.dto.LivraisonDto;
import com.smartfarm.backend.model.entities.Livraison;
import com.smartfarm.backend.repository.LivraisonRepository;
import com.smartfarm.backend.service.interfaces.ILivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivraisonServiceImpl implements ILivraison {

    @Autowired
    LivraisonRepository livraisonRepository;

    @Autowired
    LivraisonMapper livraisonMapper;

    @Override
    public List<LivraisonDto> listLivraison() {
        return livraisonRepository.findAll().stream().map( livraison -> livraisonMapper.toDto(livraison))
                .collect(Collectors.toList());
    }

    @Override
    public LivraisonDto findLivraisonById(String id) {
        if(livraisonRepository.findById(id).isPresent()){
            return livraisonMapper.toDto(livraisonRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public List<LivraisonDto> findLivraisonByStatut(String state) {
        return livraisonRepository.findByStatutLivraison(state).get().stream()
                .map(livraison -> livraisonMapper.toDto(livraison))
                .collect(Collectors.toList());
    }

    @Override
    public LivraisonDto updateOrderDelivery(LivraisonDto livraisonDto, String state) {
        Livraison livraison = livraisonRepository.findById(livraisonDto.getId()).get();
        livraisonDto.setStatutLivraison(state);
        livraisonMapper.copy(livraisonDto, livraison);
        return livraisonMapper.toDto(livraisonRepository.save(livraison));
    }
}
