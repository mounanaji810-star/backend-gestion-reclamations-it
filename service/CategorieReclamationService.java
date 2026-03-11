package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.CategorieReclamation;
import com.projet.itreclamation.repository.CategorieReclamationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategorieReclamationService {

    private final CategorieReclamationRepository repository;

    public CategorieReclamation create(CategorieReclamation categorie) {
        return repository.save(categorie);
    }

    public List<CategorieReclamation> getAll() {
        return repository.findAll();
    }

    public Optional<CategorieReclamation> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<CategorieReclamation> getByNom(String nom) {
        return repository.findByNom(nom);
    }

    public CategorieReclamation update(CategorieReclamation categorie) {
        return repository.save(categorie);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}