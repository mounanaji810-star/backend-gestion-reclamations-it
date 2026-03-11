package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.Permission;
import com.projet.itreclamation.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository repository;

    public Permission create(Permission permission) {
        return repository.save(permission);
    }

    public List<Permission> getAll() {
        return repository.findAll();
    }

    public Optional<Permission> getById(Long id) {
        return repository.findById(id);
    }

    public Permission update(Permission permission) {
        return repository.save(permission);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Permission findByName(String nom) {
        return repository.findByNom(nom);
    }
}