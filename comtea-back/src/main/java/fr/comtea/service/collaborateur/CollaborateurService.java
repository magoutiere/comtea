package fr.comtea.service.collaborateur;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import fr.comtea.service.collaborateur.repository.CollaborateurRepository;
import fr.comtea.util.ValidateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class CollaborateurService {

    private final CollaborateurRepository collaborateurRepository;

    private final CollaborateurMapper collaborateurMapper;

    private final ValidateurService validateurService;

    public void creerOuMettreAJourCollaborateurs(final List<Collaborateur> collaborateurs) {
        validateurService.valider(collaborateurs);
        var collaborateurEntities = collaborateurMapper.metiersAEntites(collaborateurs);
        collaborateurRepository.saveAll(collaborateurEntities);
    }

    public List<Collaborateur> recupererCollaborateurs() {
        var entities = collaborateurRepository.findAll();
        return collaborateurMapper.entitiesAMetiers(entities);
    }

    public Optional<Collaborateur> recupererCollaborateurParIdentifiant(final String identifiant) {
        return collaborateurRepository.findByIdentifiant(identifiant)//
            .map(collaborateurMapper::entiteAMetier);
    }
}
