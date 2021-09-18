package fr.comtea.metier.collaborateur;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

import fr.comtea.metier.collaborateur.validateur.CollaborateurUnique;

@CollaborateurUnique
public record Collaborateur(UUID id, //
                            @NotBlank(message = "L'identifiant ne doit pas être vide") String identifiant) {

    @Override
    public String toString() {
        return identifiant;
    }
}
