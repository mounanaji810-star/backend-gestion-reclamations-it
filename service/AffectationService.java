package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.Affectation;
import com.projet.itreclamation.repository.AffectationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AffectationService {

    private final AffectationRepository repository;


    public Affectation create(Affectation affectation) {
        affectation.setDateCreation(LocalDateTime.now());
        return repository.save(affectation);
    }

    public List<Affectation> getAll() {
        return repository.findAll();
    }

    public List<Affectation> getByUtilisateurId(Long utilisateurId) {
        return repository.findByUtilisateurId(utilisateurId);
    }

    public List<Affectation> getByInterventionId(Long interventionId) {
        return repository.findByInterventionId(interventionId);
    }

    public Affectation update(Affectation affectation) {
        return repository.save(affectation);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}