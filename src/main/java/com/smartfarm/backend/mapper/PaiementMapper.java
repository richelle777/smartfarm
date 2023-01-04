package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.PaiementDto;
import com.smartfarm.backend.model.entities.Paiement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface PaiementMapper {
    Paiement toEntity(PaiementDto PaiementDto);

    PaiementDto toDto(Paiement Paiement);

    void copy(PaiementDto PaiementDto, @MappingTarget Paiement Paiement);
}
