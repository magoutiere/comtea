package fr.comtea.metier.collaborateur.mapper;

import java.util.Collection;
import java.util.List;

import fr.comtea.metier.collaborateur.Collaborateur;
import fr.comtea.metier.collaborateur.repository.CollaborateurEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CollaborateurMapper {

    CollaborateurEntity metierAEntite(Collaborateur metier);

    Collaborateur entiteAMetier(CollaborateurEntity entity);

    List<CollaborateurEntity> metiersAEntites(Collection<Collaborateur> metiers);

    List<Collaborateur> entitiesAMetiers(Collection<CollaborateurEntity> entities);
}
