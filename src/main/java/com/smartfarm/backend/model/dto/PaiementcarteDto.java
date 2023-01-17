package com.smartfarm.backend.model.dto;

import com.smartfarm.backend.model.entities.Currency;
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
    private String numeroCarte;
    private LocalDate dateVerticale;
    private Currency currency;
    private PaiementDto paiementDto;
}
