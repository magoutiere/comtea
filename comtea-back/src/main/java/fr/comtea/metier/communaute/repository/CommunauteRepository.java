package fr.comtea.metier.communaute.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunauteRepository extends JpaRepository<CommunauteEntity, UUID> {

    Optional<CommunauteEntity> findByIdentifiant(String identifiant);

    void deleteByIdentifiant(String identifiant);
}
