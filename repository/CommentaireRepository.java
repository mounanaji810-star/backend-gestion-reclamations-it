package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    List<Commentaire> findByReclamationId(Long reclamationId);

    List<Commentaire> findByUtilisateurId(Long utilisateurId);
}