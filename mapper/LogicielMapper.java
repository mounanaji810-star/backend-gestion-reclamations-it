package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.LogicielDTO;
import com.projet.itreclamation.model.entity.Logiciel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LogicielMapper {

    LogicielMapper INSTANCE = Mappers.getMapper(LogicielMapper.class);

    Logiciel toEntity(LogicielDTO dto);

    LogicielDTO toDTO(Logiciel entity);
}