package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "categorie")

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categorie {
    @Id
    @Column(name = "id_categorie", nullable = false)
    private String id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "descript")
    private String description;
}