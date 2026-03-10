package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.UtilisateurDTO;
import com.projet.itreclamation.model.entity.Utilisateur;
import com.projet.itreclamation.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    @Mapping(source = "roleIds", target = "roles", qualifiedByName = "mapRoles")
    @Mapping(source = "departementId", target = "departement.id")
    @Mapping(source = "id", target = "id")
    Utilisateur toEntity(UtilisateurDTO dto);

    @Mapping(source = "roles", target = "roleIds", qualifiedByName = "mapRoleIds")
    @Mapping(source = "departement.id", target = "departementId")
    @Mapping(source = "id", target = "id")
    UtilisateurDTO toDTO(Utilisateur entity);

    @Named("mapRoles")
    default Set<Role> mapRoles(Set<Long> roleIds) {
        if (roleIds == null) return new HashSet<>();
        return roleIds.stream().map(id -> {
            Role r = new Role();
            r.setId(id);
            return r;
        }).collect(Collectors.toSet());
    }

    @Named("mapRoleIds")
    default Set<Long> mapRoleIds(Set<Role> roles) {
        if (roles == null) return new HashSet<>();
        return roles.stream().map(Role::getId).collect(Collectors.toSet());
    }
}