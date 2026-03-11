package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.JournalActivite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalActiviteRepository extends JpaRepository<JournalActivite, Long> {


    List<JournalActivite> findByUtilisateurId(Long utilisateurId);
}
