package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.Commentaire;
import com.projet.itreclamation.service.CommentaireService;
import com.projet.itreclamation.dto.CommentaireDTO;
import com.projet.itreclamation.mapper.CommentaireMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
@RequiredArgsConstructor
public class CommentaireController {

    private final CommentaireService service;
    private final CommentaireMapper mapper;

    @PostMapping
    public ResponseEntity<CommentaireDTO> create(@RequestBody CommentaireDTO dto) {
        Commentaire entity = mapper.toEntity(dto);
        Commentaire saved = service.create(entity);
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<CommentaireDTO>> getAll() {
        List<Commentaire> list = service.getAll();
        List<CommentaireDTO> dtoList = list.stream()
                .map(mapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/reclamation/{id}")
    public ResponseEntity<List<CommentaireDTO>> getByReclamation(@PathVariable Long id) {
        List<Commentaire> list = service.getByReclamation(id);
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<List<CommentaireDTO>> getByUtilisateur(@PathVariable Long id) {
        List<Commentaire> list = service.getByUtilisateur(id);
        return ResponseEntity.ok(list.stream().map(mapper::toDTO).toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}