package com.projet.itreclamation.service;

import com.projet.itreclamation.dto.UtilisateurDTO;
import com.projet.itreclamation.exception.ResourceNotFoundException;
import com.projet.itreclamation.model.entity.Utilisateur;
import com.projet.itreclamation.model.entity.Role;
import com.projet.itreclamation.model.entity.Departement;
import com.projet.itreclamation.repository.UtilisateurRepository;
import com.projet.itreclamation.repository.RoleRepository;
import com.projet.itreclamation.repository.DepartementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository repository;
    private final RoleRepository roleRepository;
    private final DepartementRepository departementRepository;
    private final PasswordEncoder passwordEncoder;

    public Utilisateur create(UtilisateurDTO dto) {
        Utilisateur u = new Utilisateur();
        u.setNom(dto.getNom());
        u.setPrenom(dto.getPrenom());
        u.setEmail(dto.getEmail());
        u.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));

        // دعم Multi-role بأمان
        if (dto.getRoleIds() != null && !dto.getRoleIds().isEmpty()) {
            Set<Role> roles = dto.getRoleIds().stream()
                    .map(id -> roleRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + id)))
                    .collect(Collectors.toSet());
            u.setRoles(roles);
        }

        if (dto.getDepartementId() != null) {
            departementRepository.findById(dto.getDepartementId())
                    .ifPresent(u::setDepartement);
        }

        return repository.save(u);
    }

    public List<Utilisateur> getAll() {
        return repository.findAll();
    }

    public Optional<Utilisateur> getById(Long id) {
        return repository.findById(id);
    }

    public Utilisateur update(Long id, UtilisateurDTO dto) {
        Utilisateur u = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found with id " + id));

        u.setNom(dto.getNom());
        u.setPrenom(dto.getPrenom());
        u.setEmail(dto.getEmail());

        if (dto.getMotDePasse() != null) {
            u.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));
        }

        if (dto.getRoleIds() != null) {
            Set<Role> roles = dto.getRoleIds().stream()
                    .map(rid -> roleRepository.findById(rid)
                            .orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + rid)))
                    .collect(Collectors.toSet());
            u.setRoles(roles);
        }

        if (dto.getDepartementId() != null) {
            departementRepository.findById(dto.getDepartementId())
                    .ifPresent(u::setDepartement);
        }

        return repository.save(u);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Utilisateur> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}