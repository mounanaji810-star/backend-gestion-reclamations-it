package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.PieceJointe;
import com.projet.itreclamation.repository.PieceJointeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PieceJointeService {

    private final PieceJointeRepository repository;

    public PieceJointe create(PieceJointe piece) {
        piece.setDateUpload(LocalDateTime.now());
        return repository.save(piece);
    }

    public List<PieceJointe> getAll() {
        return repository.findAll();
    }

    public List<PieceJointe> getByReclamation(Long reclamationId) {
        return repository.findByReclamationId(reclamationId);
    }

    public PieceJointe update(PieceJointe piece) {
        return repository.save(piece);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}