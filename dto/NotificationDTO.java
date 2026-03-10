package com.projet.itreclamation.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    private Long id;
    private String message;
    private Long utilisateurId;
    private boolean read;
    private String type;
    private LocalDateTime dateCreation;
}