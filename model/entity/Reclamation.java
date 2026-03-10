package com.projet.itreclamation.model.entity;

import com.projet.itreclamation.model.enums.EnumPriorite;
import com.projet.itreclamation.model.enums.EnumStatutReclamation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false, length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumStatutReclamation statut;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumPriorite priorite;

    private LocalDateTime dateCreation;
    private LocalDateTime dateMiseAJour;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;


    @ManyToOne
    @JoinColumn(name = "materiel_id")
    private Materiel materiel;


    @ManyToOne
    @JoinColumn(name = "logiciel_id")
    private Logiciel logiciel;


    @ManyToOne
    @JoinColumn(name = "sla_id")
    private SLA sla;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieReclamation categorieReclamation;


    @ManyToOne
    @JoinColumn(name = "localisation_id")
    private Localisation localisation;


    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @OneToMany(mappedBy = "reclamation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commentaire> commentaires;
}