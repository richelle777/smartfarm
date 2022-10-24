package com.smartfarm.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaiementcarteDto {
    private String id;
    private String crypto;
    private Long numeroCarte;
    private LocalDate dateVerticale;
    private PaiementDto paiementDto;
}
