package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.AffectationDTO;
import com.projet.itreclamation.model.entity.Affectation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AffectationMapper {

    AffectationMapper INSTANCE = Mappers.getMapper(AffectationMapper.class);

    @Mapping(source = "utilisateurId", target = "utilisateur.id")
    @Mapping(source = "interventionId", target = "intervention.id")
    Affectation toEntity(AffectationDTO dto);

    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    @Mapping(source = "intervention.id", target = "interventionId")
    AffectationDTO toDTO(Affectation entity);
}