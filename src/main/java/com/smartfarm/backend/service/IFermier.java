package com.smartfarm.backend.service;

import com.smartfarm.backend.model.dto.FermierDto;

public interface IFermier {
    FermierDto findFermierById(String id);
    FermierDto updateFermier(FermierDto fermierDto);
}
