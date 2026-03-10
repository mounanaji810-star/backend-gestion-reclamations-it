package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.Logiciel;
import com.projet.itreclamation.service.LogicielService;
import com.projet.itreclamation.dto.LogicielDTO;
import com.projet.itreclamation.mapper.LogicielMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logiciels")
@RequiredArgsConstructor
public class LogicielController {

    private final LogicielService service;
    private final LogicielMapper mapper;

    @GetMapping
    public ResponseEntity<List<LogicielDTO>> getAll() {
        List<Logiciel> list = service.getAll();
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogicielDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LogicielDTO> create(@RequestBody LogicielDTO dto) {
        Logiciel entity = mapper.toEntity(dto);
        Logiciel saved = service.create(entity);
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogicielDTO> update(@PathVariable Long id, @RequestBody LogicielDTO dto) {
        dto.setId(id);
        Logiciel entity = mapper.toEntity(dto);
        Logiciel updated = service.update(entity);
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}