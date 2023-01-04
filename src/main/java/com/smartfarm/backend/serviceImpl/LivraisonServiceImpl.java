package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.LivraisonMapper;
import com.smartfarm.backend.mapper.LocalisationMapper;
import com.smartfarm.backend.model.dto.LivraisonDto;
import com.smartfarm.backend.model.entities.Livraison;
import com.smartfarm.backend.repository.LivraisonRepository;
import com.smartfarm.backend.service.ILivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivraisonServiceImpl implements ILivraison {

    @Autowired
    LivraisonRepository livraisonRepository;

    @Autowired
    LocalisationMapper localisationMapper;

    @Autowired
    LivraisonMapper livraisonMapper;

    @Override
    public List<LivraisonDto> listLivraison() {
        List<LivraisonDto> livraisonDtos = livraisonRepository.findAll().stream().map( livraison -> {
            LivraisonDto livraisonDto = livraisonMapper.toDto(livraison);
            livraisonDto.setLocalisationDto(localisationMapper.toDto(livraison.getLocalisation()));
            return livraisonDto;
        })
                .collect(Collectors.toList());
        return livraisonDtos;
    }

    @Override
    public LivraisonDto findLivraisonById(String id) {
        if(livraisonRepository.findById(id).isPresent()){
            LivraisonDto livraisonDto = livraisonMapper.toDto(livraisonRepository.findById(id).get());
            livraisonDto.setLocalisationDto(localisationMapper.toDto(livraisonRepository.findById(id).get().getLocalisation()));
            return livraisonDto;
        }
        return null;
    }

    @Override
    public List<LivraisonDto> findLivraisonByStatut(String state) {
        return livraisonRepository.findByStatutLivraison(state).get().stream()
                .map(livraison -> {
                    LivraisonDto livraisonDto = livraisonMapper.toDto(livraison);
                    livraisonDto.setLocalisationDto(localisationMapper.toDto(livraison.getLocalisation()));
                    return livraisonDto;
                })
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
