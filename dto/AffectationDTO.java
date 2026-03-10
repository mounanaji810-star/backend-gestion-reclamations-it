package com.projet.itreclamation.dto;

import lombok.Data;

@Data
public class AffectationDTO {

    private String description;

    private Long interventionId;

    private Long utilisateurId;
}