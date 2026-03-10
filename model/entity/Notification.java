package com.projet.itreclamation.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import com.projet.itreclamation.model.enums.NotificationType;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime dateCreation = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private boolean read = false;
}