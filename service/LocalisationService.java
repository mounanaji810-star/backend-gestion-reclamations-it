package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.Localisation;
import com.projet.itreclamation.repository.LocalisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocalisationService {

    private final LocalisationRepository repository;

    public Localisation create(Localisation localisation) {
        return repository.save(localisation);
    }

    public List<Localisation> getAll() {
        return repository.findAll();
    }

    public Optional<Localisation> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Localisation> getByNom(String nom) {
        return repository.findByNom(nom);
    }

    public Localisation update(Localisation localisation) {
        return repository.save(localisation);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}