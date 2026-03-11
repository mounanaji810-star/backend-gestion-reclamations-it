package com.projet.itreclamation.service;

import com.projet.itreclamation.model.entity.Commentaire;
import com.projet.itreclamation.repository.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentaireService {

    private final CommentaireRepository repository;

    public Commentaire create(Commentaire commentaire) {
        commentaire.setDateCommentaire(LocalDateTime.now());
        return repository.save(commentaire);
    }

    public List<Commentaire> getAll() {
        return repository.findAll();
    }

    public List<Commentaire> getByReclamation(Long reclamationId) {
        return repository.findByReclamationId(reclamationId);
    }

    public List<Commentaire> getByUtilisateur(Long utilisateurId) {
        return repository.findByUtilisateurId(utilisateurId);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}