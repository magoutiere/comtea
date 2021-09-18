package fr.comtea.metier.communaute.mapper;

import java.util.List;

import fr.comtea.metier.communaute.Communaute;
import fr.comtea.metier.communaute.repository.CommunauteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunauteMapper {

    CommunauteEntity metierAEntite(Communaute metier);

    Communaute entiteAMetier(CommunauteEntity entite);

    List<Communaute> entiteAMetier(List<CommunauteEntity> entites);
}
