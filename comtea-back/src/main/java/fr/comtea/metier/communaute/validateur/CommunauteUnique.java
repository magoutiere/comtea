package fr.comtea.metier.communaute.validateur;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import fr.comtea.metier.collaborateur.validateur.CollaborateurUniqueValidateur;

@Constraint(validatedBy = CommunauteUniqueValidateur.class)
@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Documented
public @interface CommunauteUnique {

    String message() default "La communauté ${validatedValue} éxiste déjà";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
