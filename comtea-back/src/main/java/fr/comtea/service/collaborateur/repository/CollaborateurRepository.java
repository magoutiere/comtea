package fr.comtea.service.collaborateur.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaborateurRepository extends JpaRepository<CollaborateurEntity, UUID> {

    Optional<CollaborateurEntity> findByIdentifiant(String identifiant);

    void deleteByIdentifiant(String identifiant);
}
