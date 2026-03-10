package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.Affectation;
import com.projet.itreclamation.service.AffectationService;
import com.projet.itreclamation.dto.AffectationDTO;
import com.projet.itreclamation.mapper.AffectationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/affectations")
@RequiredArgsConstructor
public class AffectationController {

    private final AffectationService service;
    private final AffectationMapper mapper;

    @PostMapping
    public ResponseEntity<AffectationDTO> create(@RequestBody AffectationDTO dto) {
        Affectation entity = mapper.toEntity(dto);
        Affectation saved = service.create(entity);
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<AffectationDTO>> getAll() {
        List<Affectation> list = service.getAll();
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<List<AffectationDTO>> getByUtilisateur(@PathVariable Long id) {
        List<Affectation> list = service.getByUtilisateurId(id);
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/intervention/{id}")
    public ResponseEntity<List<AffectationDTO>> getByIntervention(@PathVariable Long id) {
        List<Affectation> list = service.getByInterventionId(id);
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffectationDTO> update(@PathVariable Long id, @RequestBody AffectationDTO dto) {
        Affectation entity = mapper.toEntity(dto);
        Affectation updated = service.update(entity);
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}