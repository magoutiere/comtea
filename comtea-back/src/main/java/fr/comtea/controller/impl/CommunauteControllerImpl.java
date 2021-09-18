package fr.comtea.controller.impl;

import java.util.List;

import fr.comtea.controller.CommunauteController;
import fr.comtea.metier.communaute.Communaute;
import fr.comtea.metier.communaute.CommunauteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommunauteControllerImpl implements CommunauteController {

    private final CommunauteService communauteService;

    @Override
    public void creerOuMettreAJour(final Communaute communaute) {
        communauteService.creerOuMettreAJourCommunaute(communaute);
    }

    @Override
    public List<Communaute> liste() {
        return communauteService.recupererCommunautes();
    }

    @Override
    public void supprimer(final String identifiant) {
        communauteService.supprimerCommunaute(identifiant);
    }
}
