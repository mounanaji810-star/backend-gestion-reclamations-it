package com.projet.itreclamation.service;

import com.projet.itreclamation.dto.NotificationDTO;
import com.projet.itreclamation.exception.ResourceNotFoundException;
import com.projet.itreclamation.model.entity.Notification;
import com.projet.itreclamation.model.enums.NotificationType;
import com.projet.itreclamation.repository.NotificationRepository;
import com.projet.itreclamation.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;
    private final UtilisateurRepository utilisateurRepository;
    private final JavaMailSender mailSender;

    // تحويل Entity إلى DTO
    private NotificationDTO toDTO(Notification n) {
        NotificationDTO dto = new NotificationDTO();
        dto.setId(n.getId());
        dto.setMessage(n.getMessage());
        dto.setUtilisateurId(n.getUtilisateur().getId());
        dto.setRead(n.isRead());
        dto.setDateCreation(n.getDateCreation());
        dto.setType(n.getType().name());
        return dto;
    }

    // إنشاء Notification كامل مع نوع محدد وإرسال البريد
    public NotificationDTO createNotification(NotificationDTO dto, NotificationType type) {
        Notification notification = new Notification();
        notification.setMessage(dto.getMessage());
        notification.setUtilisateur(utilisateurRepository.findById(dto.getUtilisateurId())
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found")));
        notification.setType(type);

        Notification saved = repository.save(notification);
        sendEmailAsync(saved);
        return toDTO(saved);
    }

    public List<NotificationDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<NotificationDTO> getByUtilisateurId(Long utilisateurId) {
        return repository.findByUtilisateurId(utilisateurId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public NotificationDTO markAsRead(Long id) {
        Notification notification = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));

        notification.setRead(true);
        Notification saved = repository.save(notification);

        return toDTO(saved);
    }

    @Async
    public void sendEmailAsync(Notification notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notification.getUtilisateur().getEmail());
        message.setSubject("إشعار جديد: " + notification.getType());
        message.setText(notification.getMessage() + "\n\nلمشاهدة التفاصيل، افتح النظام.");
        mailSender.send(message);
    }
}