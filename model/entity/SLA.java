package com.projet.itreclamation.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SLA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int delaiEnHeures;

    private LocalDateTime dateCreation;

    @PrePersist
    public void prePersist() {
        dateCreation = LocalDateTime.now(ZoneId.of("UTC"));
    }
}