package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {

    List<Affectation> findByUtilisateurId(Long utilisateurId);


    List<Affectation> findByInterventionId(Long interventionId);
}