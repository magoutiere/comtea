package fr.comtea.service.roletournant;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoriqueElectionMapper {

    HistoriqueElectionEntity metierAEntite(HistoriqueElection historiqueElection);

    HistoriqueElection entiteAMetier(HistoriqueElectionEntity entity);

    List<HistoriqueElectionEntity> metiersAEntites(Collection<HistoriqueElection> metiers);
}
