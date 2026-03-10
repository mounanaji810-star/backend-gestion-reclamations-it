package com.projet.itreclamation.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nom;


    @OneToMany(mappedBy = "departement")
    private Set<Utilisateur> utilisateurs;


    @OneToMany(mappedBy = "departement")
    private Set<Reclamation> reclamations;
}