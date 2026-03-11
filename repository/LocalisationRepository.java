package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalisationRepository extends JpaRepository<Localisation, Long> {


    Optional<Localisation> findByNom(String nom);
}
