package fr.comtea.service.collaborateur.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

import lombok.Data;

@Data
@Entity
public class CollaborateurEntity {

    @Id
    private UUID id;

    @Column(unique = true)
    private String identifiant;
}
