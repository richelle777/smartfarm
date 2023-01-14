package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.FermierDto;
import com.smartfarm.backend.model.entities.Fermier;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS,
        uses = {LocalisationMapper.class}
)
public interface FermierMapper {
    @Mapping(target = "localisation", source = "fermierDto.localisationDto")
    Fermier toEntity(FermierDto fermierDto);

    @Mapping(target = "localisationDto", source = "fermier.localisation")
    FermierDto toDto(Fermier fermier);

    @Mapping(target = "localisation", source = "fermierDto.localisationDto")
    void copy(FermierDto fermierDto, @MappingTarget Fermier fermier);
}
