package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.Logiciel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogicielRepository extends JpaRepository<Logiciel, Long> {

    Optional<Logiciel> findByNom(String nom);

    List<Logiciel> findByStatut(String statut);

    List<Logiciel> findByDateExpirationLicenceBefore(java.time.LocalDate date);
}