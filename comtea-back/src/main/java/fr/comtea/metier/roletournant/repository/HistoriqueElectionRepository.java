package fr.comtea.metier.roletournant.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueElectionRepository extends JpaRepository<HistoriqueElectionEntity, UUID> {

    List<HistoriqueElectionEntity> findAllByRole(String role);

    Optional<HistoriqueElectionEntity> findByRoleAndVainqueur(String role, String vainqueur);
}
