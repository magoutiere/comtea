package fr.comtea.metier.roletournant.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
@Entity
public class HistoriqueElectionEntity {

    @Id
    private UUID id;

    private String role;

    private String vainqueur;

    private LocalDate date;
}
