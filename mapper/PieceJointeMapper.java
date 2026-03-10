package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.PieceJointeDTO;
import com.projet.itreclamation.model.entity.PieceJointe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PieceJointeMapper {

    PieceJointeMapper INSTANCE = Mappers.getMapper(PieceJointeMapper.class);

    @Mapping(source = "reclamationId", target = "reclamation.id")
    PieceJointe toEntity(PieceJointeDTO dto);

    @Mapping(source = "reclamation.id", target = "reclamationId")
    PieceJointeDTO toDTO(PieceJointe entity);
}