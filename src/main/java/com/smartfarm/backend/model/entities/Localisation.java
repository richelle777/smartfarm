package com.smartfarm.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "localisation")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Localisation {
    @Id
    @Column(name = "id_localisation", nullable = false)
    private String id;

    @Column(name = "residence")
    private String residence;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

    @Column(name = "region")
    private String region;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "added_by")
    private String addedBy;
}