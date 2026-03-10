package com.projet.itreclamation.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InterventionDTO {

    private String description;

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    private Long utilisateurId;
}