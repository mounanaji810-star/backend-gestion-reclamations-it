package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.Reclamation;
import com.projet.itreclamation.model.enums.EnumStatutReclamation;
import com.projet.itreclamation.model.enums.EnumPriorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

    List<Reclamation> findByStatut(EnumStatutReclamation statut);

    List<Reclamation> findByPriorite(EnumPriorite priorite);

    List<Reclamation> findByUtilisateurId(Long utilisateurId);
}