package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.SLA;
import com.projet.itreclamation.service.SLAService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sla")
@RequiredArgsConstructor
public class SLAController {

    private final SLAService service;

    @PostMapping
    public ResponseEntity<SLA> create(@RequestBody SLA sla) {
        return ResponseEntity.ok(service.create(sla));
    }

    @GetMapping
    public ResponseEntity<List<SLA>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SLA> getById(@PathVariable Long id) {
        Optional<SLA> sla = service.getById(id);
        return sla.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<SLA> getByDescription(@PathVariable String description) {
        Optional<SLA> sla = service.getByDescription(description);
        return sla.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SLA> update(@PathVariable Long id, @RequestBody SLA sla) {
        sla.setId(id);
        return ResponseEntity.ok(service.update(sla));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}