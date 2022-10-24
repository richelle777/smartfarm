package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.LocalisationDto;
import com.smartfarm.backend.model.entities.Localisation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface LocalisationMapper {
    Localisation toEntity(LocalisationDto localisationDto);

    LocalisationDto toDto(Localisation localisation);

    void copy(LocalisationDto localisationDto, @MappingTarget Localisation localisation);
}
