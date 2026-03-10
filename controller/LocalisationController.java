package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.Localisation;
import com.projet.itreclamation.service.LocalisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/localisations")
@RequiredArgsConstructor
public class LocalisationController {

    private final LocalisationService service;

    @PostMapping
    public ResponseEntity<Localisation> create(@RequestBody Localisation localisation) {
        return ResponseEntity.ok(service.create(localisation));
    }

    @GetMapping
    public ResponseEntity<List<Localisation>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localisation> getById(@PathVariable Long id) {
        Optional<Localisation> loc = service.getById(id);
        return loc.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Localisation> getByNom(@PathVariable String name) {
        Optional<Localisation> loc = service.getByNom(name);
        return loc.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Localisation> update(@PathVariable Long id, @RequestBody Localisation localisation) {
        localisation.setId(id);
        return ResponseEntity.ok(service.update(localisation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}