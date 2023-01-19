package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.FermierMapper;
import com.smartfarm.backend.mapper.LocalisationMapper;
import com.smartfarm.backend.model.dto.AuthentificationFermier;
import com.smartfarm.backend.model.dto.ConnexionForm;
import com.smartfarm.backend.model.dto.FermierDto;
import com.smartfarm.backend.model.dto.LocalisationDto;
import com.smartfarm.backend.model.entities.Fermier;
import com.smartfarm.backend.repository.FermierRepository;
import com.smartfarm.backend.service.IFermier;
import com.smartfarm.backend.service.ILocalisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FermierServiceImpl implements IFermier {

    @Autowired
    FermierRepository fermierRepository;

    @Autowired
    FermierMapper fermierMapper;

    @Autowired
    ILocalisation iLocalisation;

    @Override
    public FermierDto findFermierById(String id) {
        if(fermierRepository.findById(id).isPresent()){
            FermierDto fermierDto = fermierMapper.toDto(fermierRepository.findById(id).get());
            return fermierDto;
        }
        return null;
    }

    @Override
    public String updateFermier(FermierDto fermierDto) {
        Fermier fermier = fermierRepository.findById(fermierDto.getId()).get();
        fermierMapper.copy(fermierDto, fermier);
        fermierRepository.save(fermier);
        return "Mise à jour du fermier effectué avec succés";
    }

    @Override
    public String saveLocalisation(LocalisationDto localisationDto) {
        return iLocalisation.save(localisationDto);
    }

    @Override
    public String save(FermierDto fermierDto) {
        String idLocalisation = iLocalisation.save(fermierDto.getLocalisationDto());
        fermierDto.getLocalisationDto().setId(idLocalisation);

        Boolean isIdNotNew = true;
        String id = "";
        while (isIdNotNew){
            long code = Math.round(Math.random()* 10000);
            id = "IM" + code;
            if (!fermierRepository.existsById(id))
                isIdNotNew = false;
        }
        fermierDto.setId(id);
        return fermierRepository.save(fermierMapper.toEntity(fermierDto)).getId();
    }

    @Override
    public AuthentificationFermier authentification(ConnexionForm connexionForm) {
        if(fermierRepository.existsByEmail(connexionForm.getEmail())){
            Fermier fermier = fermierRepository.findByEmail(connexionForm.getEmail()).get();
            if (fermier.getMotDePasse().equals(connexionForm.getPassword())){
                return new AuthentificationFermier(fermier.getId());
            }
        }
        return null;
    }
}
