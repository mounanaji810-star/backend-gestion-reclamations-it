package com.projet.itreclamation.security;

import com.projet.itreclamation.model.entity.RefreshToken;
import com.projet.itreclamation.model.entity.Utilisateur;
import com.projet.itreclamation.repository.RefreshTokenRepository;
import com.projet.itreclamation.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UtilisateurRepository utilisateurRepository;

    private final long refreshTokenDurationMs = 1000 * 60 * 60 * 24 * 7; // 7 أيام

    public RefreshToken createRefreshToken(Long utilisateurId) {
        RefreshToken token = new RefreshToken();
        Utilisateur user = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        token.setUtilisateur(user);
        token.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        token.setToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(token);
    }

    public boolean isTokenExpired(RefreshToken token) {
        return token.getExpiryDate().isBefore(Instant.now());
    }

    public RefreshToken findByToken(String token) {
        return refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Refresh token not found"));
    }

    public void deleteByUtilisateurId(Long utilisateurId) {
        refreshTokenRepository.deleteByUtilisateurId(utilisateurId);
    }
}