package fr.comtea.util;

import java.time.LocalDate;
import java.util.Optional;

public class ContexteDate {

    private static LocalDate dateForce = null;

    public static LocalDate aujourdhui() {
        return Optional.ofNullable(dateForce).orElseGet(LocalDate::now);
    }

    public static void forcerDateDuJour(LocalDate date) {
        dateForce = date;
    }
}
