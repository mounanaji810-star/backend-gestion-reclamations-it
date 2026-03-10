package com.projet.itreclamation.controller;

import com.projet.itreclamation.dto.LoginDTO;
import com.projet.itreclamation.model.entity.Utilisateur;
import com.projet.itreclamation.security.JwtService;
import com.projet.itreclamation.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getEmail(),
                            loginDTO.getPassword()
                    )
            );

            Utilisateur user = userDetailsService.loadFullUserByEmail(loginDTO.getEmail());


            final String token = jwtService.generateToken(user);

            return ResponseEntity.ok().body(token);

        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body("Email ou mot de passe incorrect");
        }
    }
}