package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.HistoriqueMateriel;
import com.projet.itreclamation.service.HistoriqueMaterielService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historique-materiels")
@RequiredArgsConstructor
public class HistoriqueMaterielController {

    private final HistoriqueMaterielService service;

    @GetMapping
    public ResponseEntity<List<HistoriqueMateriel>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/materiel/{id}")
    public ResponseEntity<List<HistoriqueMateriel>> getByMateriel(@PathVariable Long id) {
        return ResponseEntity.ok(service.getByMateriel(id));
    }

    @PostMapping
    public ResponseEntity<HistoriqueMateriel> create(@RequestBody HistoriqueMateriel historique) {
        return ResponseEntity.ok(service.create(historique));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriqueMateriel> update(@PathVariable Long id, @RequestBody HistoriqueMateriel historique) {
        historique.setId(id);
        return ResponseEntity.ok(service.update(historique));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}