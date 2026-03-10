package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.JournalActivite;
import com.projet.itreclamation.repository.JournalActiviteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalService {

    private final JournalActiviteRepository repository;


    public JournalActivite create(JournalActivite journal) {
        journal.setDateAction(LocalDateTime.now());
        return repository.save(journal);
    }


    public JournalActivite update(JournalActivite journal) {
        Optional<JournalActivite> existing = repository.findById(journal.getId());
        if (existing.isPresent()) {
            JournalActivite j = existing.get();
            j.setAction(journal.getAction());
            j.setUtilisateur(journal.getUtilisateur());
            j.setDateAction(LocalDateTime.now());
            return repository.save(j);
        } else {
            throw new RuntimeException("JournalActivite not found");
        }
    }

    public List<JournalActivite> getAll() {
        return repository.findAll();
    }


    public List<JournalActivite> getByUtilisateur(Long utilisateurId) {
        return repository.findByUtilisateurId(utilisateurId);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}