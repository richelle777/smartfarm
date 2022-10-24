package com.smartfarm.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommandearticleDto {
    private CommandearticleIdDto id;
    private Integer quantite;
}
