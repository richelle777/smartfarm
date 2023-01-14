package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.PaiementcarteDto;
import com.smartfarm.backend.model.entities.Paiementcarte;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS,
        uses = {PaiementMapper.class}
)
public interface PaiementcarteMapper {
    @Mapping(target = "paiement", source = "paiementcarteDto.paiementDto")
    Paiementcarte toEntity(PaiementcarteDto paiementcarteDto);

    @Mapping(target = "paiementDto", source = "paiementcarte.paiement")
    PaiementcarteDto toDto(Paiementcarte paiementcarte);

    @Mapping(target = "paiement", source = "paiementcarteDto.paiementDto")
    void copy(PaiementcarteDto paiementcarteDto, @MappingTarget Paiementcarte paiementcarte);
}
