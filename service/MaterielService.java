package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.Materiel;
import com.projet.itreclamation.repository.MaterielRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterielService {

    private final MaterielRepository repository;

    public Materiel create(Materiel materiel) {
        return repository.save(materiel);
    }

    public List<Materiel> getAll() {
        return repository.findAll();
    }

    public Optional<Materiel> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Materiel> getByReference(String reference) {
        return repository.findByReference(reference);
    }

    public List<Materiel> getByStatut(String statut) {
        return repository.findByStatut(statut);
    }

    public Materiel update(Materiel materiel) {
        return repository.save(materiel);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}