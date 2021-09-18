package fr.comtea.phrases;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import fr.comtea.controller.CollaborateurController;
import fr.comtea.metier.collaborateur.Collaborateur;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CollaborateurPhrases {

    private final CollaborateurController collaborateurController;

    @Etantdonné("les collaborateurs suivants :")
    public void preparerCollaborateurs(final List<Collaborateur> collaborateurs) {
        collaborateurs.forEach(collaborateurController::creer);
    }

    @Quand("je crée le(s) collaborateur(s) suivant(s) :")
    public void creerCollaborateurs(final List<Collaborateur> collaborateurs) {
        try {
            collaborateurs.forEach(collaborateurController::creer);
        } catch (final Exception ex) {
            ContexteTest.setException(ex);
        }
    }

    @Quand("je supprime le collaborateur {string}")
    public void supprimerCollaborateur(final String identifiant) {
        collaborateurController.supprimer(identifiant);
    }

    @Alors("j'obtiens les collaborateurs suivants :")
    public void verifierCollaborateurs(final List<Collaborateur> collaborateursAttendus) {
        List<Collaborateur> collaborateurs = collaborateurController.liste();

        assertThat(collaborateurs)//
            .usingElementComparatorIgnoringFields("id")//
            .containsExactlyInAnyOrderElementsOf(collaborateursAttendus);
    }
}
