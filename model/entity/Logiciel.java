package com.projet.itreclamation.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logiciel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String version;

    @Column(nullable = false)
    private String fournisseur;

    @Column(nullable = false)
    private String statut;

    private LocalDate dateExpirationLicence;


    @OneToMany(mappedBy = "logiciel")
    private List<Reclamation> reclamations;


    @ManyToMany
    @JoinTable(
            name = "logiciel_materiel",
            joinColumns = @JoinColumn(name = "logiciel_id"),
            inverseJoinColumns = @JoinColumn(name = "materiel_id")
    )
    private List<Materiel> materiels;
}