package fr.comtea.phrases;

import java.util.List;

import fr.comtea.service.collaborateur.Collaborateur;
import fr.comtea.service.collaborateur.CollaborateurService;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CollaborateurPhrases {

    private final CollaborateurService collaborateurService;

    @Etantdonné("les collaborateurs suivants :")
    public void preparerCollaborateurs(final List<Collaborateur> collaborateurs) {
        collaborateurService.creerOuMettreAJourCollaborateurs(collaborateurs);
    }

    @Quand("je crée le(s) collaborateur(s) suivant(s) :")
    public void creerCollaborateurs(final List<Collaborateur> collaborateurs) {
        try {
            collaborateurService.creerOuMettreAJourCollaborateurs(collaborateurs);
        }catch (final Exception ex){
            ContexteTest.setException(ex);
        }
    }
}
