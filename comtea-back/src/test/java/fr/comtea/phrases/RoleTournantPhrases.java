package fr.comtea.phrases;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import fr.comtea.controller.RoleTournantController;
import fr.comtea.metier.roletournant.HistoriqueElection;
import fr.comtea.metier.roletournant.RoleTournantService;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleTournantPhrases {

    private final RoleTournantService roleTournantService;

    private final RoleTournantController roleTournantController;

    @Etantdonné("l'historique des élus :")
    public void preparerHistoriqueElus(final List<HistoriqueElection> historiqueElections) {
        roleTournantService.creerOuMettreAJourHistoriqueElection(historiqueElections);
    }

    @Quand("je lance l'élection pour le role {string}")
    public void lancerElectionRole(final String role) {
        var collaborateur = roleTournantController.election(role);
        ContexteTest.setVainqueurElectionObtenu(collaborateur);
    }

    @Alors("le vainqueur de l'élection est le collaborateur {string}")
    public void verifierVainqueurElection(final String identifiantAttendu) {
        var collaborateur = ContexteTest.getVainqueurElectionObtenu();
        var identifiantObtenu = collaborateur.getIdentifiant();

        assertThat(identifiantObtenu).isEqualTo(identifiantAttendu);
    }

    @Alors("j'obtiens l'historique des élus pour le role {string} :")
    public void verifierHistoriqueElus(final String role, final List<HistoriqueElection> historiqueElectionAttendu) {
        var historiqueElectionObtenu = roleTournantService.recupererHistoriqueElectionPourRole(role);

        assertThat(historiqueElectionObtenu)//
            .usingElementComparatorIgnoringFields("id")//
            .containsExactlyInAnyOrderElementsOf(historiqueElectionAttendu);
    }

    @Alors("le vainqueur de l'élection est l'un des collaborateur suivant :")
    public void verifierVainqueurParmiListeCollaborateur(final List<String> identifiantsAttendus) {
        var collaborateur = ContexteTest.getVainqueurElectionObtenu();
        var identifiantObtenu = collaborateur.getIdentifiant();

        assertThat(identifiantObtenu).isIn(identifiantsAttendus);
    }
}
