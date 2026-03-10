package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.HistoriqueStatut;
import com.projet.itreclamation.service.HistoriqueStatutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historique-status")
@RequiredArgsConstructor
public class HistoriqueStatutController {

    private final HistoriqueStatutService service;

    @PostMapping
    public ResponseEntity<HistoriqueStatut> create(@RequestBody HistoriqueStatut hs) {
        return ResponseEntity.ok(service.create(hs));
    }

    @GetMapping
    public ResponseEntity<List<HistoriqueStatut>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/reclamation/{id}")
    public ResponseEntity<List<HistoriqueStatut>> getByReclamation(@PathVariable Long id) {
        return ResponseEntity.ok(service.getByReclamation(id));
    }
}