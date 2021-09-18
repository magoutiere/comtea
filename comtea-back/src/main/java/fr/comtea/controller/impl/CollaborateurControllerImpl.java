package fr.comtea.controller.impl;

import java.util.List;

import fr.comtea.controller.CollaborateurController;
import fr.comtea.metier.collaborateur.Collaborateur;
import fr.comtea.metier.collaborateur.CollaborateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CollaborateurControllerImpl implements CollaborateurController {

    private final CollaborateurService collaborateurService;

    @Override
    public void creer(final Collaborateur collaborateur) {
        collaborateurService.creerOuMettreAJourCollaborateurs(List.of(collaborateur));
    }

    @Override
    public List<Collaborateur> liste() {
        return collaborateurService.recupererCollaborateurs();
    }

    @Override
    public void supprimer(final String identifiant) {
        collaborateurService.supprimerCollaborateur(identifiant);
    }
}
