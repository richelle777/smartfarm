package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customer")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @Column(name = "id_client", nullable = false)
    private String id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mdp", nullable = false)
    private String motDePasse;

    @Column(name = "telephone", nullable = false)
    private Long telephone;
}