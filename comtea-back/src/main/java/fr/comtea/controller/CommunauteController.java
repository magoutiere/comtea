package fr.comtea.controller;

import javax.validation.Valid;
import java.util.List;

import fr.comtea.metier.communaute.Communaute;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "communaute-api")
@RequestMapping("/api/communaute")
public interface CommunauteController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void creerOuMettreAJourCommunaute(@Valid @RequestBody Communaute communaute);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Communaute> recupererCommunautes();

    @DeleteMapping("/{identifiant}")
    void supprimerCommunaute(@PathVariable String identifiant);
}
