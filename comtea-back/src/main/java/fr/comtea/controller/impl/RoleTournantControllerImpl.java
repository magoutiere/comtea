package fr.comtea.controller.impl;

import java.util.List;

import fr.comtea.controller.RoleTournantController;
import fr.comtea.metier.collaborateur.Collaborateur;
import fr.comtea.metier.roletournant.HistoriqueElection;
import fr.comtea.metier.roletournant.RoleTournantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoleTournantControllerImpl implements RoleTournantController {

    private final RoleTournantService roleTournantService;

    @Override
    public List<HistoriqueElection> historique(final String role) {
        return roleTournantService.recupererHistoriqueElectionPourRole(role);
    }

    @Override
    public Collaborateur election(final String role) {
        return roleTournantService.lancerElectionPourRole(role);
    }
}

