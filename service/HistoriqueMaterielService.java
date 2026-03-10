package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.HistoriqueMateriel;
import com.projet.itreclamation.repository.HistoriqueMaterielRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoriqueMaterielService {

    private final HistoriqueMaterielRepository repository;


    public HistoriqueMateriel create(HistoriqueMateriel historique) {
        historique.setDateAction(LocalDateTime.now());
        return repository.save(historique);
    }

    public List<HistoriqueMateriel> getAll() {
        return repository.findAll();
    }


    public List<HistoriqueMateriel> getByMateriel(Long materielId) {
        return repository.findByMaterielId(materielId);
    }

    public HistoriqueMateriel update(HistoriqueMateriel historique) {
        historique.setDateAction(LocalDateTime.now());
        return repository.save(historique);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}