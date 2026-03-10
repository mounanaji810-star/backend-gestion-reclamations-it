package com.projet.itreclamation.service;

import com.projet.itreclamation.dto.ReclamationDTO;
import com.projet.itreclamation.model.entity.Notification;
import com.projet.itreclamation.model.entity.Reclamation;
import com.projet.itreclamation.model.entity.Utilisateur;
import com.projet.itreclamation.repository.ReclamationRepository;
import com.projet.itreclamation.repository.UtilisateurRepository;
import com.projet.itreclamation.model.enums.EnumStatutReclamation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.projet.itreclamation.repository.MaterielRepository;
import com.projet.itreclamation.repository.LogicielRepository;
import com.projet.itreclamation.repository.SLARepository;
import com.projet.itreclamation.model.enums.EnumPriorite;
import com.projet.itreclamation.dto.NotificationDTO;
import com.projet.itreclamation.model.enums.NotificationType;

@Service
@RequiredArgsConstructor
public class ReclamationService {

    private final ReclamationRepository reclamationRepository;
    private final NotificationService notificationService;
    private final UtilisateurRepository utilisateurRepository;
    private final MaterielRepository materielRepository;
    private final LogicielRepository logicielRepository;
    private final SLARepository slaRepository;

    // إنشاء Réclamation جديدة
    public Reclamation create(ReclamationDTO dto) {

        Utilisateur utilisateur = utilisateurRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        Reclamation reclamation = new Reclamation();
        reclamation.setTitre(dto.getTitre());
        reclamation.setDescription(dto.getDescription());
        reclamation.setPriorite(dto.getPriorite());
        reclamation.setStatut(EnumStatutReclamation.OUVERTE);
        reclamation.setDateCreation(LocalDateTime.now());
        reclamation.setDateMiseAJour(LocalDateTime.now());
        reclamation.setUtilisateur(utilisateur);

        if (dto.getMaterielId() != null) {
            reclamation.setMateriel(
                    materielRepository.findById(dto.getMaterielId())
                            .orElseThrow(() -> new RuntimeException("Materiel non trouvé"))
            );
        }

        if (dto.getLogicielId() != null) {
            reclamation.setLogiciel(
                    logicielRepository.findById(dto.getLogicielId())
                            .orElseThrow(() -> new RuntimeException("Logiciel non trouvé"))
            );
        }

        if (dto.getSlaId() != null) {
            reclamation.setSla(
                    slaRepository.findById(dto.getSlaId())
                            .orElseThrow(() -> new RuntimeException("SLA non trouvé"))
            );
        }

        Reclamation saved = reclamationRepository.save(reclamation);

        // إنشاء Notification بطريقة منظمة عبر دالة خاصة
        sendReclamationNotification(
                utilisateur.getId(),
                "Nouvelle réclamation créée : " + saved.getTitre(),
                NotificationType.ASSIGNMENT
        );

        return saved;
    }

    // تحديث حالة Réclamation
    public Reclamation updateStatus(Long id, EnumStatutReclamation newStatut) {

        Reclamation reclamation = reclamationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reclamation non trouvée"));

        reclamation.setStatut(newStatut);
        reclamation.setDateMiseAJour(LocalDateTime.now());

        Reclamation saved = reclamationRepository.save(reclamation);

        sendReclamationNotification(
                reclamation.getUtilisateur().getId(),
                "Statut de votre réclamation '" + reclamation.getTitre() + "' mis à jour : " + newStatut,
                NotificationType.UPDATE
        );

        return saved;
    }

    public List<Reclamation> getAll() {
        return reclamationRepository.findAll();
    }

    public List<Reclamation> getByStatut(EnumStatutReclamation statut) {
        return reclamationRepository.findByStatut(statut);
    }

    public List<Reclamation> getByPriorite(EnumPriorite priorite) {
        return reclamationRepository.findByPriorite(priorite);
    }

    /** دالة private منظمة لإرسال Notification */
    private void sendReclamationNotification(Long utilisateurId, String message, NotificationType type) {
        NotificationDTO notifDTO = new NotificationDTO();
        notifDTO.setUtilisateurId(utilisateurId);
        notifDTO.setMessage(message);
        notificationService.createNotification(notifDTO, type);
    }
}