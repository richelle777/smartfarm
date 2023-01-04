package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "livraison", indexes = {
        @Index(name = "id_localisation", columnList = "id_localisation")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Livraison {
    @Id
    @Column(name = "id_livraison", nullable = false)
    private String id;

    @Column(name = "date_liv")
    private LocalDate date;

    @Lob
    @Column(name = "statut_livraison")
    private String statutLivraison;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_localisation", nullable = false)
    private Localisation localisation;
}