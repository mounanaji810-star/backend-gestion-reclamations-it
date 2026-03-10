package com.projet.itreclamation.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class PieceJointeDTO {

    private Long id;

    @NotBlank
    private String nomFichier;

    @NotBlank
    private String url;

    @NotNull
    private Long reclamationId;
}