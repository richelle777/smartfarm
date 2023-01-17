package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "paiementcarte", indexes = {
        @Index(name = "id_paiement", columnList = "id_paiement")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Paiementcarte {
    @Id
    @Column(name = "id_pc", nullable = false)
    private String id;

    @Column(name = "crypto")
    private String crypto;

    @Column(name = "numero_carte")
    private String numeroCarte;

    @Column(name = "date_verticale", nullable = false)
    private LocalDate dateVerticale;

    @Column(name = "devise", nullable = false)
    private Currency currency;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paiement", nullable = false)
    private Paiement paiement;
}