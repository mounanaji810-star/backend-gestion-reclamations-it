package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.CategorieReclamation;
import com.projet.itreclamation.service.CategorieReclamationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategorieReclamationController {

    private final CategorieReclamationService service;

    @PostMapping
    public ResponseEntity<CategorieReclamation> create(@RequestBody CategorieReclamation categorie) {
        return ResponseEntity.ok(service.create(categorie));
    }

    @GetMapping
    public ResponseEntity<List<CategorieReclamation>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorieReclamation> getById(@PathVariable Long id) {
        Optional<CategorieReclamation> c = service.getById(id);
        return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategorieReclamation> getByNom(@PathVariable String name) {
        Optional<CategorieReclamation> c = service.getByNom(name);
        return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategorieReclamation> update(@PathVariable Long id, @RequestBody CategorieReclamation categorie) {
        categorie.setId(id);
        return ResponseEntity.ok(service.update(categorie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}