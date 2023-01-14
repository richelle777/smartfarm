package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.CommandeMapper;
import com.smartfarm.backend.mapper.CustomerMapper;
import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.dto.Produit;
import com.smartfarm.backend.model.entities.Commande;
import com.smartfarm.backend.repository.CommandeRepository;
import com.smartfarm.backend.service.ICommande;
import com.smartfarm.backend.service.ICommandearticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImpl implements ICommande {

    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    CommandeMapper commandeMapper;

    @Autowired
    ICommandearticle iCommandearticle;

    @Override
    public List<CommandeDto> listCommandes() {
        List<CommandeDto> commandeDtos = commandeRepository.findAll().stream().map(commande -> {
            CommandeDto commandeDto = commandeMapper.toDto(commande);
            return commandeDto;
        }).collect(Collectors.toList());
        return commandeDtos;
    }

    @Override
    public CommandeDto findById(String id) {
        return commandeMapper.toDto( commandeRepository.findCommandeById(id).get());
    }

    @Override
    public String deleteById(String id) {
        commandeRepository.deleteById(id);
        return "Suppression effectué avec succés";
    }

    @Override
    public String saveCommande(CommandeDto commandeDto) {
        if(commandeRepository.findCommandeById(commandeDto.getId()).isPresent()){
            return "0";
        }
        else {
            return commandeRepository.save(commandeMapper.toEntity(commandeDto)).getId();
        }
    }

    @Override
    public String updateStatut(String id, String state) {
        CommandeDto commandeDto = commandeMapper.toDto(commandeRepository.findById(id).get());
        commandeDto.setStatutCommande(state);
        commandeRepository.save(commandeMapper.toEntity(commandeDto));
        return "Mise à jour effectué avec succés";
    }

    @Override
    public Map<CommandeDto, List<Produit>> historiqueCommandeClient(String id) {
        Map<CommandeDto, List<Produit>> map = new HashMap<>();
        List<CommandeDto> commandeDtos = commandeRepository.findByClient_Id(id).get().stream()
                .map(commande -> {
                    CommandeDto commandeDto = commandeMapper.toDto(commande);
                    return commandeDto;
                }).collect(Collectors.toList());
        for(CommandeDto commandeDto  : commandeDtos){
            List<Produit> produits = iCommandearticle.listArticleByCommande(commandeDto.getId());
            map.put(commandeDto, produits);
        }
        return map;
    }
}
