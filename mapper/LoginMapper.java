package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.LoginDTO;
import com.projet.itreclamation.model.entity.Utilisateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {

    LoginMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(LoginMapper.class);


}