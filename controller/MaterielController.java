package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.Materiel;
import com.projet.itreclamation.service.MaterielService;
import com.projet.itreclamation.dto.MaterielDTO;
import com.projet.itreclamation.mapper.MaterielMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiels")
@RequiredArgsConstructor
public class MaterielController {

    private final MaterielService service;
    private final MaterielMapper mapper;

    @GetMapping
    public ResponseEntity<List<MaterielDTO>> getAll() {
        List<Materiel> list = service.getAll();
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterielDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MaterielDTO> create(@RequestBody MaterielDTO dto) {
        Materiel entity = mapper.toEntity(dto);
        Materiel saved = service.create(entity);
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterielDTO> update(@PathVariable Long id, @RequestBody MaterielDTO dto) {
        dto.setId(id);
        Materiel entity = mapper.toEntity(dto);
        Materiel updated = service.update(entity);
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}