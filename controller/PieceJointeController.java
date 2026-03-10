package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.PieceJointe;
import com.projet.itreclamation.service.PieceJointeService;
import com.projet.itreclamation.dto.PieceJointeDTO;
import com.projet.itreclamation.mapper.PieceJointeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pieces-jointes")
@RequiredArgsConstructor
public class PieceJointeController {

    private final PieceJointeService service;
    private final PieceJointeMapper mapper;

    @GetMapping
    public ResponseEntity<List<PieceJointeDTO>> getAll() {
        List<PieceJointe> list = service.getAll();
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/reclamation/{id}")
    public ResponseEntity<List<PieceJointeDTO>> getByReclamation(@PathVariable Long id) {
        List<PieceJointe> list = service.getByReclamation(id);
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @PostMapping
    public ResponseEntity<PieceJointeDTO> create(@RequestBody PieceJointeDTO dto) {
        PieceJointe entity = mapper.toEntity(dto);
        PieceJointe saved = service.create(entity);
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PieceJointeDTO> update(@PathVariable Long id, @RequestBody PieceJointeDTO dto) {
        dto.setId(id);
        PieceJointe entity = mapper.toEntity(dto);
        PieceJointe updated = service.update(entity);
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}