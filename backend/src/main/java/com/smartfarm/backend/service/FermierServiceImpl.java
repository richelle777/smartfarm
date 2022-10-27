package com.smartfarm.backend.service;

import com.smartfarm.backend.mapper.FermierMapper;
import com.smartfarm.backend.model.dto.FermierDto;
import com.smartfarm.backend.model.entities.Fermier;
import com.smartfarm.backend.repository.FermierRepository;
import com.smartfarm.backend.service.interfaces.IFermier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FermierServiceImpl implements IFermier {

    @Autowired
    FermierRepository fermierRepository;

    @Autowired
    FermierMapper fermierMapper;

    @Override
    public FermierDto findFermierById(String id) {
        return fermierMapper.toDto(fermierRepository.findById(id).get());
    }

    @Override
    public FermierDto updateFermier(FermierDto fermierDto) {
        Fermier fermier = fermierRepository.findById(fermierDto.getId()).get();
        fermierMapper.copy(fermierDto, fermier);
        return fermierMapper.toDto(fermierRepository.save(fermier));
    }
}
