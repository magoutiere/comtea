package fr.comtea.metier.roletournant;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.comtea.metier.collaborateur.Collaborateur;
import fr.comtea.metier.collaborateur.CollaborateurService;
import fr.comtea.metier.roletournant.mapper.HistoriqueElectionMapper;
import fr.comtea.metier.roletournant.repository.HistoriqueElectionEntity;
import fr.comtea.metier.roletournant.repository.HistoriqueElectionRepository;
import fr.comtea.util.ContexteDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class RoleTournantService {

    private final HistoriqueElectionMapper historiqueElectionMapper;

    private final HistoriqueElectionRepository historiqueElectionRepository;

    private final CollaborateurService collaborateurService;

    public Collaborateur lancerElectionPourRole(final String role) {
        var collaborateurs = collaborateurService.recupererCollaborateurs();
        var historiqueParRole = historiqueElectionRepository.findAllByRole(role);

        var collaborateurVainqueur = definirVainqueur(collaborateurs, historiqueParRole);

        enregistrerHistoriqueVainqueur(role, collaborateurVainqueur);

        return collaborateurVainqueur;
    }

    private Collaborateur definirVainqueur(final List<Collaborateur> collaborateurs, final List<HistoriqueElectionEntity> historiqueParRole) {
        var collaborateurSansHistorique = trouverCollaborateurSansHistorique(collaborateurs, historiqueParRole);

        return collaborateurSansHistorique//
            .orElseGet(() -> trouverCollaborateurAvecHistoriqueLePlusAncien(historiqueParRole)//
                .orElseThrow());
    }

    private void enregistrerHistoriqueVainqueur(final String role, final Collaborateur collaborateurGagnant) {
        var nouvelHistorique = historiqueElectionRepository.findByRoleAndVainqueur(role, collaborateurGagnant.getIdentifiant())//
            .map(historiqueElectionMapper::entiteAMetier)//
            .orElseGet(() -> {
                HistoriqueElection historique = new HistoriqueElection();
                historique.setRole(role);
                historique.setVainqueur(collaborateurGagnant.getIdentifiant());
                return historique;
            });

        nouvelHistorique.setDate(ContexteDate.aujourdhui());
        creerOuMettreAJourHistoriqueElection(List.of(nouvelHistorique));
    }

    private Optional<Collaborateur> trouverCollaborateurAvecHistoriqueLePlusAncien(final List<HistoriqueElectionEntity> historiqueParRole) {
        return historiqueParRole.stream()//
            .min(Comparator.comparing(HistoriqueElectionEntity::getDate))//
            .flatMap(historique -> collaborateurService.recupererCollaborateurParIdentifiant(historique.getVainqueur()));
    }

    private Optional<Collaborateur> trouverCollaborateurSansHistorique(final List<Collaborateur> collaborateurs,
        final List<HistoriqueElectionEntity> historiqueParRole) {
        return collaborateurs.stream()//
            .filter(collaborateur -> historiqueParRole.stream()
                .noneMatch(historique -> Objects.equals(historique.getVainqueur(), collaborateur.getIdentifiant())))//
            .findFirst();
    }

    public void creerOuMettreAJourHistoriqueElection(final List<HistoriqueElection> historiqueElection) {
        var entites = historiqueElectionMapper.metiersAEntites(historiqueElection);
        historiqueElectionRepository.saveAll(entites);
    }

    public List<HistoriqueElection> recupererHistoriqueElectionPourRole(final String role) {
        return historiqueElectionRepository.findAllByRole(role).stream()//
            .map(historiqueElectionMapper::entiteAMetier)//
            .collect(Collectors.toList());
    }
}
