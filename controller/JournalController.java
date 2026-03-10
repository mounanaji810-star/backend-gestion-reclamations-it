package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.JournalActivite;
import com.projet.itreclamation.service.JournalService;
import com.projet.itreclamation.dto.JournalActiviteDTO;
import com.projet.itreclamation.mapper.JournalActiviteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journals")
@RequiredArgsConstructor
public class JournalController {

    private final JournalService service;
    private final JournalActiviteMapper mapper;

    @GetMapping
    public ResponseEntity<List<JournalActiviteDTO>> getAll() {
        List<JournalActivite> list = service.getAll();
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<JournalActiviteDTO>> getByUtilisateur(@PathVariable Long id) {
        List<JournalActivite> list = service.getByUtilisateur(id);
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @PostMapping
    public ResponseEntity<JournalActiviteDTO> create(@RequestBody JournalActiviteDTO dto) {
        JournalActivite entity = mapper.toEntity(dto);
        JournalActivite saved = service.create(entity);
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalActiviteDTO> update(@PathVariable Long id, @RequestBody JournalActiviteDTO dto) {
        dto.setId(id);
        JournalActivite entity = mapper.toEntity(dto);
        JournalActivite updated = service.update(entity);
        return ResponseEntity.ok(mapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}