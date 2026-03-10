package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.Logiciel;
import com.projet.itreclamation.repository.LogicielRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogicielService {

    private final LogicielRepository repository;

    public Logiciel create(Logiciel logiciel) {
        return repository.save(logiciel);
    }

    public List<Logiciel> getAll() {
        return repository.findAll();
    }

    public Optional<Logiciel> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Logiciel> getByNom(String nom) {
        return repository.findByNom(nom);
    }

    public List<Logiciel> getByStatut(String statut) {
        return repository.findByStatut(statut);
    }

    public List<Logiciel> getLicencesExpirees() {
        return repository.findByDateExpirationLicenceBefore(LocalDate.now());
    }

    public Logiciel update(Logiciel logiciel) {
        return repository.save(logiciel);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}