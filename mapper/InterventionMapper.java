package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.InterventionDTO;
import com.projet.itreclamation.model.entity.Intervention;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InterventionMapper {

    InterventionMapper INSTANCE = Mappers.getMapper(InterventionMapper.class);

    @Mapping(source = "utilisateurId", target = "utilisateur.id")
    Intervention toEntity(InterventionDTO dto);

    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    InterventionDTO toDTO(Intervention entity);
}