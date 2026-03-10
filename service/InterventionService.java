package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.Intervention;
import com.projet.itreclamation.repository.InterventionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterventionService {

    private final InterventionRepository repository;


    public Intervention create(Intervention intervention) {
        intervention.setDateCreation(LocalDateTime.now());
        return repository.save(intervention);
    }

    public List<Intervention> getAll() {
        return repository.findAll();
    }

    public List<Intervention> getByUtilisateurId(Long utilisateurId) {
        return repository.findByUtilisateurId(utilisateurId);
    }

    public Intervention update(Intervention intervention) {
        return repository.save(intervention);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}