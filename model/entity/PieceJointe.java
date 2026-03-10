package com.projet.itreclamation.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class PieceJointe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String url;
    private String type;

    private LocalDateTime dateUpload;

    @ManyToOne
    @JoinColumn(name = "reclamation_id")
    private Reclamation reclamation;
}