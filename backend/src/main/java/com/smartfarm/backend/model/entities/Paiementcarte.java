package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "paiementcarte", indexes = {
        @Index(name = "idPaiement", columnList = "idPaiement")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Paiementcarte {
    @Id
    @Column(name = "idPC", nullable = false)
    private String id;

    @Column(name = "crypto")
    private String crypto;

    @Column(name = "numeroCarte")
    private Long numeroCarte;

    @Column(name = "dateVerticale", nullable = false)
    private LocalDate dateVerticale;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idPaiement", nullable = false)
    private Paiement paiement;
}