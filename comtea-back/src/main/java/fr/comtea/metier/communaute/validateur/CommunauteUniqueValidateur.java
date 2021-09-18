package fr.comtea.metier.communaute.validateur;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

import fr.comtea.metier.communaute.Communaute;
import fr.comtea.metier.communaute.CommunauteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommunauteUniqueValidateur implements ConstraintValidator<CommunauteUnique, Communaute> {

    private final CommunauteService communauteService;

    @Override
    public boolean isValid(final Communaute communaute, final ConstraintValidatorContext constraintValidatorContext) {
        var communauteExistante = communauteService.recupererCommunauteParIdentifiant(communaute.identifiant());
        return communauteExistante.isEmpty() || Objects.equals(communauteExistante.get().id(), communaute.id());
    }
}
