package com.projet.itreclamation.controller;

import com.projet.itreclamation.model.entity.RefreshToken;
import com.projet.itreclamation.model.entity.Utilisateur;
import com.projet.itreclamation.security.JwtService;
import com.projet.itreclamation.security.RefreshTokenService;
import com.projet.itreclamation.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/refresh")
@RequiredArgsConstructor
public class RefreshTokenController {

    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    private final UtilisateurRepository utilisateurRepository;

    @PostMapping
    public ResponseEntity<?> refreshToken(@RequestParam String refreshToken) {

        // البحث عن الـ refresh token
        RefreshToken token = refreshTokenService.findByToken(refreshToken);

        if (refreshTokenService.isTokenExpired(token)) {
            return ResponseEntity.badRequest().body("Refresh token expired");
        }

        Utilisateur user = token.getUtilisateur();
        String newJwt = jwtService.generateToken(user);

        return ResponseEntity.ok(new JwtResponse(newJwt, refreshToken));
    }

    // نموذج الرد
    private record JwtResponse(String jwt, String refreshToken) {}
}