package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.FermierDto;
import com.smartfarm.backend.model.entities.Fermier;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface FermierMapper {
    Fermier toEntity(FermierDto fermierDto);

    FermierDto toDto(Fermier fermier);

    void copy(FermierDto fermierDto, @MappingTarget Fermier fermier);
}
