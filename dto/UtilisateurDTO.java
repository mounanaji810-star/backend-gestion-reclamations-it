package com.projet.itreclamation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {

    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @Email(message = "Email invalide")
    @NotBlank(message = "Email est obligatoire")
    private String email;

    @Size(min = 6, message = "Mot de passe doit avoir au moins 6 caractères")
    private String motDePasse;

    private Set<Long> roleIds;  // لدعم Multi-role
    private Long departementId;
}