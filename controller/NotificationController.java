package com.projet.itreclamation.controller;

import com.projet.itreclamation.dto.NotificationDTO;
import com.projet.itreclamation.model.enums.NotificationType;
import com.projet.itreclamation.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @GetMapping
    public ResponseEntity<List<NotificationDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/user/{utilisateurId}")
    public ResponseEntity<List<NotificationDTO>> getByUser(@PathVariable Long utilisateurId) {
        return ResponseEntity.ok(service.getByUtilisateurId(utilisateurId));
    }

    @PostMapping("/create")
    public ResponseEntity<NotificationDTO> create(@RequestBody NotificationDTO dto,
                                                  @RequestParam NotificationType type) {
        return ResponseEntity.ok(service.createNotification(dto, type));
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<NotificationDTO> markAsRead(@PathVariable Long id) {
        return ResponseEntity.ok(service.markAsRead(id));
    }
}