package fr.comtea.service.collaborateur;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

import fr.comtea.service.collaborateur.validateur.CollaborateurUnique;
import lombok.Data;

@Data
@CollaborateurUnique
public class Collaborateur {

    private UUID id = UUID.randomUUID();

    @NotBlank(message = "L'identifiant ne doit pas être vide")
    private String identifiant;
}
