package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.Departement;
import com.projet.itreclamation.repository.DepartementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartementService {

    private final DepartementRepository repository;

    public Departement create(Departement departement) {
        return repository.save(departement);
    }

    public List<Departement> getAll() {
        return repository.findAll();
    }

    public Optional<Departement> getById(Long id) {
        return repository.findById(id);
    }

    public Departement update(Departement departement) {
        return repository.save(departement);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Departement findByName(String nom) {
        return repository.findByNom(nom);
    }
}