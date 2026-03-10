package com.projet.itreclamation.repository;

import com.projet.itreclamation.model.entity.SLA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SLARepository extends JpaRepository<SLA, Long> {

    Optional<SLA> findByDescription(String description);
}