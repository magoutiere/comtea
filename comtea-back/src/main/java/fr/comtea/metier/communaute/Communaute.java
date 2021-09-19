package fr.comtea.metier.communaute;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

import fr.comtea.metier.communaute.validateur.CommunauteUnique;

@CommunauteUnique
public record Communaute(UUID id,//
                         @NotBlank(message = "L'identifiant ne doit pas être vide") String identifiant,//
                         @NotBlank(message = "Le nom ne doit pas être vide") String nom) //
{

    @Override
    public String toString() {
        return identifiant;
    }
}
