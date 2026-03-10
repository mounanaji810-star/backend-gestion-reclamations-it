package com.projet.itreclamation.dto;

import com.projet.itreclamation.model.enums.EnumPriorite;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReclamationDTO {

    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String titre;

    @NotBlank(message = "La description est obligatoire")
    private String description;

    private EnumPriorite priorite;
    private String email; // utilisateur créateur
    private Long materielId;
    private Long logicielId;
    private Long slaId;
}