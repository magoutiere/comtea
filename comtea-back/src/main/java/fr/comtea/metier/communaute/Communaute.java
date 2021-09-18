package fr.comtea.metier.communaute;

import java.util.UUID;

import fr.comtea.metier.communaute.validateur.CommunauteUnique;

@CommunauteUnique
public record Communaute(UUID id, String identifiant, String nom) {

    @Override
    public String toString() {
        return identifiant;
    }
}
