package fr.comtea.metier.roletournant;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class HistoriqueElection {

    private UUID id;

    private String role;

    private String vainqueur;

    private LocalDate date;
}
