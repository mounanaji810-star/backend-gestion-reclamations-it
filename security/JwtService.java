package com.projet.itreclamation.security;

import com.projet.itreclamation.model.entity.Utilisateur;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final String SECRET = "ma_clé_secrète_super_secure";

    // إنشاء JWT مع Claims للأدوار
    public String generateToken(Utilisateur user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("roles", user.getRoles().stream()
                        .map(role -> role.getNom())
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 ساعة
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token, Utilisateur user) {
        final String username = extractUsername(token);
        return username.equals(user.getEmail());
    }
}