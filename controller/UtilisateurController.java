package com.projet.itreclamation.controller;

import com.projet.itreclamation.dto.UtilisateurDTO;
import com.projet.itreclamation.model.entity.Utilisateur;
import com.projet.itreclamation.service.UtilisateurService;
import com.projet.itreclamation.mapper.UtilisateurMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService service;
    private final UtilisateurMapper mapper;

    @PostMapping
    public ResponseEntity<UtilisateurDTO> create(@Valid @RequestBody UtilisateurDTO dto) {
        Utilisateur saved = service.create(dto);
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAll() {
        List<Utilisateur> list = service.getAll();
        List<UtilisateurDTO> dtoList = list.stream()
                .map(mapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> update(@PathVariable Long id, @Valid @RequestBody UtilisateurDTO dto) {
        // الآن Update يأخذ id و DTO مباشرة من Service
        Utilisateur updated = service.update(id, dto);
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UtilisateurDTO> getByEmail(@PathVariable String email) {
        return service.findByEmail(email)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}