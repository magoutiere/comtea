package fr.comtea.util;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateurService {

    private final Validator validator;

    public <T> void valider(final Collection<T> listeObjets) {
        var violations = listeObjets.stream()//
            .map(validator::validate)//
            .flatMap(Collection::stream)//
            .collect(Collectors.toSet());

        if (!violations.isEmpty()) {
            String message = violations.stream()//
                .map(ConstraintViolation::getMessage)//
                .collect(Collectors.joining(","));
            throw new ConstraintViolationException(message, violations);
        }
    }

    public <T> void valider(final T objet) {
        valider(Collections.singleton(objet));
    }
}
