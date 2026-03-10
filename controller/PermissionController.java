package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.Permission;
import com.projet.itreclamation.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService service;

    @PostMapping
    public ResponseEntity<Permission> create(@RequestBody Permission permission) {
        return ResponseEntity.ok(service.create(permission));
    }

    @GetMapping
    public ResponseEntity<List<Permission>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> update(@PathVariable Long id, @RequestBody Permission permission) {
        permission.setId(id);
        return ResponseEntity.ok(service.update(permission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}