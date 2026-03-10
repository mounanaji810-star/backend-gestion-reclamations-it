package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.JournalActiviteDTO;
import com.projet.itreclamation.model.entity.JournalActivite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface JournalActiviteMapper {

    JournalActiviteMapper INSTANCE = Mappers.getMapper(JournalActiviteMapper.class);

    @Mapping(source = "utilisateurId", target = "utilisateur.id")
    JournalActivite toEntity(JournalActiviteDTO dto);

    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    JournalActiviteDTO toDTO(JournalActivite entity);
}