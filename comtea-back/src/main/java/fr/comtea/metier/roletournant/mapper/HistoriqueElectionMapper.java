package fr.comtea.metier.roletournant.mapper;

import java.util.Collection;
import java.util.List;

import fr.comtea.metier.roletournant.HistoriqueElection;
import fr.comtea.metier.roletournant.repository.HistoriqueElectionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoriqueElectionMapper {

    HistoriqueElectionEntity metierAEntite(HistoriqueElection historiqueElection);

    HistoriqueElection entiteAMetier(HistoriqueElectionEntity entity);

    List<HistoriqueElectionEntity> metiersAEntites(Collection<HistoriqueElection> metiers);
}
