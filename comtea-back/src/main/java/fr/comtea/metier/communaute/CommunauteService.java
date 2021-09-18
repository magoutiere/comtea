package fr.comtea.metier.communaute;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import fr.comtea.metier.communaute.mapper.CommunauteMapper;
import fr.comtea.metier.communaute.repository.CommunauteRepository;
import fr.comtea.util.ValidateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class CommunauteService {

    private final CommunauteRepository communauteRepository;

    private final CommunauteMapper communauteMapper;

    private final ValidateurService validateurService;

    public void creerOuMettreAJourCommunaute(final Communaute communaute) {
        validateurService.valider(communaute);
        var entite = communauteMapper.metierAEntite(communaute);
        communauteRepository.save(entite);
    }

    public List<Communaute> recupererCommunautes() {
        var entites = communauteRepository.findAll();
        return communauteMapper.entiteAMetier(entites);
    }

    public void supprimerCommunaute(final String identifiant) {
        communauteRepository.deleteByIdentifiant(identifiant);
    }

    public Optional<Communaute> recupererCommunauteParIdentifiant(final String identifiant) {
        var entite = communauteRepository.findByIdentifiant(identifiant);
        return entite.map(communauteMapper::entiteAMetier);
    }
}
