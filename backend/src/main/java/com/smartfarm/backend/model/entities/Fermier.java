package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "fermier", indexes = {
        @Index(name = "id_localisation", columnList = "id_localisation")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fermier {
    @Id
    @Column(name = "id_fermier", nullable = false)
    private String id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "pwd", nullable = false)
    private String motDePasse;

    @Column(name = "tel", nullable = false)
    private Long telephone;

    @ManyToOne
    @JoinColumn(name = "id_localisation")
    private Localisation localisation;
}