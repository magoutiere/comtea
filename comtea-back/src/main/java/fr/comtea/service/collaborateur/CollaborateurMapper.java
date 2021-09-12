package fr.comtea.service.collaborateur;

import java.util.Collection;
import java.util.List;

import fr.comtea.service.collaborateur.repository.CollaborateurEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CollaborateurMapper {

    CollaborateurEntity metierAEntite(Collaborateur metier);

    Collaborateur entiteAMetier(CollaborateurEntity entity);

    List<CollaborateurEntity> metiersAEntites(Collection<Collaborateur> metiers);

    List<Collaborateur> entitiesAMetiers(Collection<CollaborateurEntity> entities);
}
