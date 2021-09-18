package fr.comtea.phrases;

import fr.comtea.metier.collaborateur.Collaborateur;

public class ContexteTest {

    private static final ThreadLocal<Contexte> CONTEXTE = new ThreadLocal<>();

    static {
        reinitialiser();
    }

    public static void reinitialiser() {
        CONTEXTE.set(new Contexte());
    }

    public static void setVainqueurElectionObtenu(final Collaborateur collaborateur) {
        CONTEXTE.get().vainqueurElectionObtenu = collaborateur;
    }

    public static Collaborateur getVainqueurElectionObtenu() {
        return CONTEXTE.get().vainqueurElectionObtenu;
    }

    public static void setException(final Exception ex) {
        CONTEXTE.get().exception = ex;
    }

    public static Throwable getException() {
        return CONTEXTE.get().exception;
    }

    public static void nettoyerException() {
        CONTEXTE.get().exception = null;
    }

    private static class Contexte {
        private Collaborateur vainqueurElectionObtenu;
        private Throwable exception;
    }
}
