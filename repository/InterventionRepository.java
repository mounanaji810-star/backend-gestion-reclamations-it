package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {

    List<Intervention> findByUtilisateurId(Long utilisateurId);
}
