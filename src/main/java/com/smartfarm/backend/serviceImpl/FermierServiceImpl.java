package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.FermierMapper;
import com.smartfarm.backend.mapper.LocalisationMapper;
import com.smartfarm.backend.model.dto.FermierDto;
import com.smartfarm.backend.model.entities.Fermier;
import com.smartfarm.backend.repository.FermierRepository;
import com.smartfarm.backend.service.IFermier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FermierServiceImpl implements IFermier {

    @Autowired
    FermierRepository fermierRepository;

    @Autowired
    LocalisationMapper localisationMapper;

    @Autowired
    FermierMapper fermierMapper;

    @Override
    public FermierDto findFermierById(String id) {
        if(fermierRepository.findById(id).isPresent()){
            FermierDto fermierDto = fermierMapper.toDto(fermierRepository.findById(id).get());
            fermierDto.setLocalisationDto(localisationMapper.toDto(fermierRepository.findById(id).get().getLocalisation()));
            return fermierDto;
        }
        return null;
    }

    @Override
    public FermierDto updateFermier(FermierDto fermierDto) {
        Fermier fermier = fermierRepository.findById(fermierDto.getId()).get();
        fermierMapper.copy(fermierDto, fermier);
        return fermierMapper.toDto(fermierRepository.save(fermier));
    }
}
