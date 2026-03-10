package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.HistoriqueStatut;
import com.projet.itreclamation.repository.HistoriqueStatutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoriqueStatutService {

    private final HistoriqueStatutRepository repository;


    public HistoriqueStatut create(HistoriqueStatut hs) {
        hs.setDateModification(LocalDateTime.now());
        return repository.save(hs);
    }

    public List<HistoriqueStatut> getAll() {
        return repository.findAll();
    }


    public List<HistoriqueStatut> getByReclamation(Long reclamationId) {
        return repository.findByReclamationId(reclamationId);
    }
}