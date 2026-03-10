package com.projet.itreclamation.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class MaterielDTO {

    private Long id;

    @NotBlank
    private String nom;

    @NotBlank
    private String reference;

    @NotBlank
    private String statut;

    private String description;
}