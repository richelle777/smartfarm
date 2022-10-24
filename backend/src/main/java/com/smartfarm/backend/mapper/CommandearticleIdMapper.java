package com.smartfarm.backend.mapper;

import com.smartfarm.backend.model.dto.CommandearticleIdDto;
import com.smartfarm.backend.model.entities.CommandearticleId;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface CommandearticleIdMapper {
    CommandearticleId toEntity(CommandearticleIdDto commandearticleIdDto);

    CommandearticleIdDto toDto(CommandearticleId commandearticleId);

    void copy(CommandearticleIdDto commandearticleIdDto, @MappingTarget CommandearticleId commandearticleId);
}
