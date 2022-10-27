package com.smartfarm.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LivraisonDto {
    private String id;
    private LocalDate date;
    private String statutLivraison;
    private LocalisationDto localisationDto;
}