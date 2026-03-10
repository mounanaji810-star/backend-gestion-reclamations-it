package com.projet.itreclamation.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class CommentaireDTO {

    @NotBlank
    private String contenu;

    private Long utilisateurId;

    private Long reclamationId;
}