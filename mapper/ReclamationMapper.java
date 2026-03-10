package com.projet.itreclamation.mapper;

import com.projet.itreclamation.dto.ReclamationDTO;
import com.projet.itreclamation.model.entity.Reclamation;
import com.projet.itreclamation.model.enums.EnumPriorite;
import com.projet.itreclamation.model.enums.EnumStatutReclamation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class ReclamationMapper {

    public Reclamation toEntity(ReclamationDTO dto) {
        Reclamation rec = new Reclamation();
        rec.setTitre(dto.getTitre());
        rec.setDescription(dto.getDescription());
        rec.setPriorite(dto.getPriorite());
        rec.setStatut(EnumStatutReclamation.OUVERTE);
        return rec;
    }

    public ReclamationDTO toDTO(Reclamation entity) {
        ReclamationDTO dto = new ReclamationDTO();
        dto.setTitre(entity.getTitre());
        dto.setDescription(entity.getDescription());
        dto.setPriorite(entity.getPriorite());
        dto.setEmail(entity.getUtilisateur().getEmail());
        return dto;
    }
}