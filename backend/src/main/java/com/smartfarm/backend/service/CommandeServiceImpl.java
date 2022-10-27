package com.smartfarm.backend.service;

import com.smartfarm.backend.mapper.CommandeMapper;
import com.smartfarm.backend.model.dto.CommandeDto;
import com.smartfarm.backend.repository.CommandeRepository;
import com.smartfarm.backend.service.interfaces.ICommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImpl implements ICommande {

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    CommandeMapper commandeMapper;

    @Override
    public CommandeDto updateStatutCommande(String id, String state) {
        CommandeDto commandeDto = commandeMapper.toDto(commandeRepository.findById(id).get());
        commandeDto.setStatutCommande(state);
        commandeRepository.save(commandeMapper.toEntity(commandeDto));
        return commandeDto;
    }
}
