package fr.comtea.metier.collaborateur.validateur;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Constraint(validatedBy = CollaborateurUniqueValidateur.class)
@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Documented
public @interface CollaborateurUnique {

    String message() default "Le collaborateur ${validatedValue.identifiant} éxiste déjà";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
