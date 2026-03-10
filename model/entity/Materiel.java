package com.projet.itreclamation.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(unique = true, nullable = false)
    private String reference;

    @Column(nullable = false)
    private String statut;


    @ManyToOne
    @JoinColumn(name = "localisation_id")
    private Localisation localisation;


    @OneToMany(mappedBy = "materiel")
    private List<Reclamation> reclamations;


    @OneToMany(mappedBy = "materiel")
    private List<HistoriqueMateriel> historiques;
}