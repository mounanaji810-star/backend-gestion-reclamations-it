package com.projet.itreclamation.controller;

import com.projet.itreclamation.dto.ReclamationDTO;
import com.projet.itreclamation.model.entity.Reclamation;
import com.projet.itreclamation.model.enums.EnumStatutReclamation;
import com.projet.itreclamation.service.ReclamationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projet.itreclamation.mapper.ReclamationMapper;


import java.util.List;
import com.projet.itreclamation.model.enums.EnumPriorite;

@RestController
@RequestMapping("/api/reclamations")
@RequiredArgsConstructor
public class ReclamationController {

    private final ReclamationService service;
    private final ReclamationMapper mapper;

    @PostMapping
    public ResponseEntity<ReclamationDTO> create(@RequestBody ReclamationDTO dto) {
        Reclamation entity = mapper.toEntity(dto);
        Reclamation saved = service.create(dto);
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<ReclamationDTO>> getAll() {
        List<Reclamation> list = service.getAll();
        List<ReclamationDTO> dtoList = list.stream().map(mapper::toDTO).toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/statut/{statut}")
    public ResponseEntity<List<ReclamationDTO>> getByStatut(@PathVariable EnumStatutReclamation statut) {
        List<Reclamation> list = service.getByStatut(statut);
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/priorite/{priorite}")
    public ResponseEntity<List<ReclamationDTO>> getByPriorite(@PathVariable EnumPriorite priorite) {
        List<Reclamation> list = service.getByPriorite(priorite);
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ReclamationDTO> updateStatus(@PathVariable Long id,
                                                       @RequestParam EnumStatutReclamation statut) {
        Reclamation updated = service.updateStatus(id, statut);
        return ResponseEntity.ok(mapper.toDTO(updated));
    }
}