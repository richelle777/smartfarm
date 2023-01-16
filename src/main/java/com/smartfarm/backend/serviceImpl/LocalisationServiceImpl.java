package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.LocalisationMapper;
import com.smartfarm.backend.model.dto.ArticleDto;
import com.smartfarm.backend.model.dto.LocalisationDto;
import com.smartfarm.backend.model.entities.Localisation;
import com.smartfarm.backend.repository.LocalisationRepository;
import com.smartfarm.backend.service.ILocalisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalisationServiceImpl implements ILocalisation {

    @Autowired
    LocalisationRepository localisationRepository;

    @Autowired
    LocalisationMapper localisationMapper;

    @Override
    public String save(LocalisationDto localisationDto) {
        //Function to create a new id for the localisation
        Boolean isIdNotNew = true;
        String id = "";
        while (isIdNotNew){
            long code = Math.round(Math.random()* 10000);
            id = "AR" + code;
            if (!localisationRepository.existsById(id))
                isIdNotNew = false;
        }
        localisationDto.setId(id);
        localisationDto.setDeleted(false);
        localisationRepository.save(localisationMapper.toEntity(localisationDto));
        return "Enregistrement effectué avec succés";
    }

    @Override
    public String update(LocalisationDto localisationDto) {
        Localisation localisation = localisationRepository.findById(localisationDto.getId()).get();
        localisationMapper.copy(localisationDto, localisation);
        localisationRepository.save(localisation);
        return "Mise à jour effectué avec succés";
    }

    @Override
    public String delete(String id) {
        localisationRepository.deleteById(id);
        return "Suppression effectué avec succés";
    }

    @Override
    public String hideLocalisation(String id) {
        Localisation localisation = localisationRepository.findById(id).get();
        localisation.setDeleted(true);
        localisationRepository.save(localisation);
        return "mise a jour reussi";
    }

    @Override
    public List<LocalisationDto> getLocalisationUser(String id) {
        List<LocalisationDto> localisationDtos = localisationRepository.findByAdded_by(id).stream().map(local ->{
            LocalisationDto localisationDto = localisationMapper.toDto(local);
            return localisationDto;
        }).collect(Collectors.toList());
        return localisationDtos;
    }


}
