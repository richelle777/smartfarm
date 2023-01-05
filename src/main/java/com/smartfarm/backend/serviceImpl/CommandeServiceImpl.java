package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.CommandeMapper;
import com.smartfarm.backend.mapper.CustomerMapper;
import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.model.entities.Commande;
import com.smartfarm.backend.repository.CommandeRepository;
import com.smartfarm.backend.service.ICommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImpl implements ICommande {

    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    CommandeMapper commandeMapper;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<CommandeDto> listCommandes() {
        List<CommandeDto> commandeDtos = commandeRepository.findAll().stream().map(commande -> {
            CommandeDto commandeDto = commandeMapper.toDto(commande);
            commandeDto.setClientDto(customerMapper.toDto(commande.getClient()));
            return commandeDto;
        }).collect(Collectors.toList());
        return commandeDtos;
    }

    @Override
    public CommandeDto searchArticleById(String id) {
        return commandeMapper.toDto( commandeRepository.findCommandeById(id).get());
    }

    @Override
    public int deleteCommandeById(String id) {
        commandeRepository.deleteById(commandeRepository.findCommandeById(id).get().getId());
        return 1;
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
