package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long> {

    Optional<Materiel> findByReference(String reference);

    List<Materiel> findByStatut(String statut);
}