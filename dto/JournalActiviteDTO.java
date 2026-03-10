package com.projet.itreclamation.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class JournalActiviteDTO {

    private Long id;

    private String action; // وصف النشاط

    private Long utilisateurId;

    private LocalDateTime dateAction;
}