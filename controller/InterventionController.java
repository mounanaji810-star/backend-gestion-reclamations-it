package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.Intervention;
import com.projet.itreclamation.service.InterventionService;
import com.projet.itreclamation.dto.InterventionDTO;
import com.projet.itreclamation.mapper.InterventionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/interventions")
@RequiredArgsConstructor
public class InterventionController {

    private final InterventionService service;
    private final InterventionMapper mapper;

    @PostMapping
    public ResponseEntity<InterventionDTO> create(@RequestBody InterventionDTO dto) {
        Intervention entity = mapper.toEntity(dto);
        Intervention saved = service.create(entity);
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<InterventionDTO>> getAll() {
        List<Intervention> list = service.getAll();
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<List<InterventionDTO>> getByUtilisateur(@PathVariable Long id) {
        List<Intervention> list = service.getByUtilisateurId(id);
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterventionDTO> update(@PathVariable Long id, @RequestBody InterventionDTO dto) {
        Intervention entity = mapper.toEntity(dto);
        entity.setId(id);
        Intervention updated = service.update(entity);
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}