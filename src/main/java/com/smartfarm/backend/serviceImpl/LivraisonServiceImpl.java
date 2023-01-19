package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.LivraisonMapper;
import com.smartfarm.backend.model.dto.LivraisonDto;
import com.smartfarm.backend.model.entities.Livraison;
import com.smartfarm.backend.repository.LivraisonRepository;
import com.smartfarm.backend.service.ILivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivraisonServiceImpl implements ILivraison {

    @Autowired
    LivraisonRepository livraisonRepository;

    @Autowired
    LivraisonMapper livraisonMapper;

    @Override
    public List<LivraisonDto> listLivraison() {
        List<LivraisonDto> livraisonDtos = livraisonRepository.findAll().stream().map(livraison -> {
                    LivraisonDto livraisonDto = livraisonMapper.toDto(livraison);
                    return livraisonDto;
                })
                .collect(Collectors.toList());
        return livraisonDtos;
    }

    @Override
    public String save(LivraisonDto livraisonDto) {
        //Function to create a new id for the localisation
        Boolean isIdNotNew = true;
        String id = "";
        while (isIdNotNew){
            long code = Math.round(Math.random()* 10000);
            id = "LI" + code;
            if (!livraisonRepository.existsById(id))
                isIdNotNew = false;
        }
        livraisonDto.setId(id);
        livraisonDto.setStatutLivraison("Non livré");
        livraisonRepository.save(livraisonMapper.toEntity(livraisonDto));
        return "Enregistrement effectué avec succés";
    }

    @Override
    public LivraisonDto findLivraisonById(String id) {
        if (livraisonRepository.findById(id).isPresent()) {
            LivraisonDto livraisonDto = livraisonMapper.toDto(livraisonRepository.findById(id).get());
            return livraisonDto;
        }
        return null;
    }

    @Override
    public List<LivraisonDto> findLivraisonByStatut(String state) {
        return livraisonRepository.findByStatutLivraison(state).get().stream()
                .map(livraison -> {
                    LivraisonDto livraisonDto = livraisonMapper.toDto(livraison);
                    return livraisonDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String updateOrderDelivery(String id, String state) {
        Livraison livraison = livraisonRepository.findById(id).get();
        livraisonRepository.save(livraison);
        return "Mise à jour du statut de livraison à : " + state;
    }


}