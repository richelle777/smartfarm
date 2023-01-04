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
    CustomerMapper customerMapper;

    @Autowired
    ICommandearticle iCommandearticle;

    @Override
    public CommandeDto updateStatutCommande(String id, String state) {
        CommandeDto commandeDto = commandeMapper.toDto(commandeRepository.findById(id).get());
        commandeDto.setStatutCommande(state);
        commandeDto.setClientDto(customerMapper.toDto(commandeRepository.findById(id).get().getClient()));
        Commande commande = commandeMapper.toEntity(commandeDto);
        commande.setClient(customerMapper.toEntity(commandeDto.getClientDto()));
        commandeRepository.save(commande);
        return commandeDto;
    }

    @Override
    public Map<CommandeDto, List<Produit>> historiqueCommandeClient(String id) {
        Map<CommandeDto, List<Produit>> map = new HashMap<>();
        List<CommandeDto> commandeDtos = commandeRepository.findByClient_Id(id).get().stream()
                .map(commande -> {
                    CommandeDto commandeDto = commandeMapper.toDto(commande);
                    commandeDto.setClientDto(customerMapper.toDto(commande.getClient()));
                    return commandeDto;
                }).collect(Collectors.toList());
        for(CommandeDto commandeDto  : commandeDtos){
            List<Produit> produits = iCommandearticle.listArticleByCommande(commandeDto.getId());
            map.put(commandeDto, produits);
        }
        return map;
    }
}
