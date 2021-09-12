package fr.comtea.service.collaborateur.validateur;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

import fr.comtea.service.collaborateur.Collaborateur;
import fr.comtea.service.collaborateur.CollaborateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CollaborateurUniqueValidateur implements ConstraintValidator<CollaborateurUnique, Collaborateur> {

    private final CollaborateurService collaborateurService;

    @Override
    public boolean isValid(final Collaborateur collaborateur, final ConstraintValidatorContext constraintValidatorContext) {
        var collaborateurExistant = collaborateurService.recupererCollaborateurParIdentifiant(collaborateur.getIdentifiant());
        return collaborateurExistant.isEmpty() || Objects.equals(collaborateurExistant.get().getId(), collaborateur.getId());
    }
}
