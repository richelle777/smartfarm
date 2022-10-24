package com.smartfarm.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommandeDto {
    private String id;
    private LocalDate date;
    private Boolean livre = false;
    private String statutCommande;
    private CustomerDto clientDto;
}
