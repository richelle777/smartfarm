package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.CommandeMapper;
import com.smartfarm.backend.mapper.CustomerMapper;
import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.entities.Commande;
import com.smartfarm.backend.repository.CommandeRepository;
import com.smartfarm.backend.service.ICommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImpl implements ICommande {

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    CommandeMapper commandeMapper;

    @Autowired
    CustomerMapper customerMapper;

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
}
