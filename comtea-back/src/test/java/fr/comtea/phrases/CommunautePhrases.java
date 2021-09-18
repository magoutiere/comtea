package fr.comtea.phrases;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import fr.comtea.controller.CommunauteController;
import fr.comtea.metier.communaute.Communaute;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommunautePhrases {

    private final CommunauteController communauteController;

    @Soit("les communautées existantes :")
    public void preparerCommunautesExistantes(final List<Communaute> communautesExistantes) {
        communautesExistantes.forEach(communauteController::creerOuMettreAJourCommunaute);
    }

    @Quand("je crée la communauté :")
    public void creerCommunaute(final List<Communaute> communautes) {
        try {
            communautes.forEach(communauteController::creerOuMettreAJourCommunaute);
        } catch (final Exception exception) {
            ContexteTest.setException(exception);
        }
    }

    @Alors("j'obtiens communautées existantes :")
    public void verifierCommunauteExistantes(final List<Communaute> communautesAttendues) {
        var communautesObtenues = communauteController.recupererCommunautes();

        assertThat(communautesObtenues)//
            .usingElementComparatorIgnoringFields("id")//
            .containsExactlyInAnyOrderElementsOf(communautesAttendues);
    }

    @Quand("je supprime la communauté {string}")
    public void supprimerCommunaute(final String identifiant) {
        communauteController.supprimerCommunaute(identifiant);
    }
}
