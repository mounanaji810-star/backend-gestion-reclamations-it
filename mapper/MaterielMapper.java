package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.MaterielDTO;
import com.projet.itreclamation.model.entity.Materiel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MaterielMapper {

    MaterielMapper INSTANCE = Mappers.getMapper(MaterielMapper.class);

    Materiel toEntity(MaterielDTO dto);

    MaterielDTO toDTO(Materiel entity);
}