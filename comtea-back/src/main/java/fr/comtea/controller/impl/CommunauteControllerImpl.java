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
    public void creerOuMettreAJourCommunaute(final Communaute communaute) {
        communauteService.creerOuMettreAJourCommunaute(communaute);
    }

    @Override
    public List<Communaute> recupererCommunautes() {
        return communauteService.recupererCommunautes();
    }

    @Override
    public void supprimerCommunaute(final String identifiant) {
        communauteService.supprimerCommunaute(identifiant);
    }
}
