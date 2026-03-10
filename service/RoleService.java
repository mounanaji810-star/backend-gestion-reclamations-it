package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.Role;
import com.projet.itreclamation.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public Role create(Role role) {
        return repository.save(role);
    }

    public Page<Role> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Role> getById(Long id) {
        return repository.findById(id);
    }

    public Role update(Role role) {
        return repository.save(role);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Role findByName(String nom) {
        return repository.findByNom(nom);
    }
}