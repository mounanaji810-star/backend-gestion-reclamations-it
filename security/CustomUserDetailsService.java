package com.projet.itreclamation.security;

import com.projet.itreclamation.model.entity.Utilisateur;
import com.projet.itreclamation.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // دعم Multi-role
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getNom()))
                .collect(Collectors.toList());

        return User.builder()
                .username(user.getEmail())
                .password(user.getMotDePasse())
                .authorities(authorities)
                .build();
    }

    // مساعدة للحصول على كائن Utilisateur كامل من البريد
    public Utilisateur loadFullUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}