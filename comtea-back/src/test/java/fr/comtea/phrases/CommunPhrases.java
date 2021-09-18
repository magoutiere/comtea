package fr.comtea.phrases;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;
import java.time.LocalDate;

import fr.comtea.util.ContexteDate;
import io.cucumber.java.After;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class CommunPhrases {

    private final ApplicationContext applicationContext;

    @After
    public void nettoyerBase() {
        var repositories = applicationContext.getBeansOfType(JpaRepository.class);
        repositories.forEach((s, jpaRepository) -> {
            jpaRepository.deleteAll();
        });
    }

    @After
    public void verifierAbsenceErreurEnFinTest() throws Throwable {
        if (ContexteTest.getException() != null) {
            throw ContexteTest.getException();
        }
    }

    @Etantdonné("la date du jour {localDate}")
    public void preparerDateDuJour(final LocalDate date) {
        ContexteDate.forcerDateDuJour(date);
    }

    @Alors("j'obtiens une erreur {string}")
    public void verifierErreur(final String messageAttendu) {
        Throwable exception = ContexteTest.getException();
        ContexteTest.nettoyerException();

        assertThat(exception).isNotNull();

        String messageObtenu = exception.getMessage();
        assertThat(messageObtenu).isEqualTo(messageAttendu);
    }
}
