package com.projet.itreclamation.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class LogicielDTO {

    private Long id;

    @NotBlank
    private String nom;

    @NotBlank
    private String statut;

    private LocalDate dateExpiration;
}