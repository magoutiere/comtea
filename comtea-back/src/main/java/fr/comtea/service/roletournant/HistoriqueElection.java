package fr.comtea.service.roletournant;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class HistoriqueElection {

    private UUID id = UUID.randomUUID();

    private String role;

    private String vainqueur;

    private LocalDate date;
}
