package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.PaiementcarteDto;
import com.smartfarm.backend.model.entities.Paiementcarte;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface PaiementcarteMapper {
    Paiementcarte toEntity(PaiementcarteDto PaiementcarteDto);

    PaiementcarteDto toDto(Paiementcarte Paiementcarte);

    void copy(PaiementcarteDto PaiementcarteDto, @MappingTarget Paiementcarte Paiementcarte);
}
