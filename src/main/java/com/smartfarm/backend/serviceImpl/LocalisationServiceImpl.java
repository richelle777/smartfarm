package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.LocalisationMapper;
import com.smartfarm.backend.model.dto.LocalisationDto;
import com.smartfarm.backend.model.entities.Localisation;
import com.smartfarm.backend.repository.LocalisationRepository;
import com.smartfarm.backend.service.ILocalisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalisationServiceImpl implements ILocalisation {

    @Autowired
    LocalisationRepository localisationRepository;

    @Autowired
    LocalisationMapper localisationMapper;

    @Override
    public String saveLocalisation(LocalisationDto localisationDto) {
        if (localisationRepository.findById(localisationDto.getId()).isPresent()){
            return null;
        }
        return localisationRepository.save(localisationMapper.toEntity(localisationDto)).getId();
    }

    @Override
    public LocalisationDto updateLocalisation(LocalisationDto localisationDto) {
        Localisation localisation = localisationRepository.findById(localisationDto.getId()).get();
        localisationMapper.copy(localisationDto, localisation);
        return localisationMapper.toDto(localisationRepository.save(localisation));
    }

    @Override
    public void deleteLocalisation(LocalisationDto localisationDto) {
        localisationRepository.delete(localisationMapper.toEntity(localisationDto));
    }
}
