package com.smartfarm.backend.model.dto;

import com.smartfarm.backend.model.entities.CommandearticleId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommandearticleDto {
    private CommandearticleId id;
    private Integer quantite;
}
