package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.CategorieReclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieReclamationRepository extends JpaRepository<CategorieReclamation, Long> {

    Optional<CategorieReclamation> findByNom(String nom);
}