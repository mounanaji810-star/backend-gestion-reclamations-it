package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.HistoriqueStatut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriqueStatutRepository extends JpaRepository<HistoriqueStatut, Long> {

    List<HistoriqueStatut> findByReclamationId(Long reclamationId);
}
