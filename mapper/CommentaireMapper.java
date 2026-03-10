package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.CommentaireDTO;
import com.projet.itreclamation.model.entity.Commentaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentaireMapper {

    CommentaireMapper INSTANCE = Mappers.getMapper(CommentaireMapper.class);

    @Mapping(source = "utilisateurId", target = "utilisateur.id")
    @Mapping(source = "reclamationId", target = "reclamation.id")
    Commentaire toEntity(CommentaireDTO dto);

    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    @Mapping(source = "reclamation.id", target = "reclamationId")
    CommentaireDTO toDTO(Commentaire entity);
}