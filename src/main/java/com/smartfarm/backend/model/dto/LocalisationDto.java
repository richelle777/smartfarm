package com.smartfarm.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocalisationDto {
    private String id;
    private String residence;
    private String ville;
    private String pays;
    private String region;
    private String longitude;
    private String latitude;
    private String added_by;
    private boolean deleted;
}
