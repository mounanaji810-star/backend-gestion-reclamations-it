package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.Departement;
import com.projet.itreclamation.service.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
@RequiredArgsConstructor
public class DepartementController {

    private final DepartementService service;

    @PostMapping
    public ResponseEntity<Departement> create(@RequestBody Departement departement) {
        return ResponseEntity.ok(service.create(departement));
    }

    @GetMapping
    public ResponseEntity<List<Departement>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{nom}")
    public ResponseEntity<Departement> getByName(@PathVariable String nom) {
        return ResponseEntity.ok(service.findByName(nom));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> update(@PathVariable Long id, @RequestBody Departement departement) {
        departement.setId(id);
        return ResponseEntity.ok(service.update(departement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}