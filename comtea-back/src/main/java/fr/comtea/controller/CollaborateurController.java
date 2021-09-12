package fr.comtea.controller;

import javax.validation.Valid;
import java.util.List;

import fr.comtea.service.collaborateur.Collaborateur;
import fr.comtea.service.collaborateur.CollaborateurService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "collaborateur-api")
@RequestMapping("/api/collaborateur")
public class CollaborateurController {

    private final CollaborateurService collaborateurService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creer(@Valid @RequestBody final Collaborateur collaborateur) {
        collaborateurService.creerOuMettreAJourCollaborateurs(List.of(collaborateur));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Collaborateur> liste() {
        return collaborateurService.recupererCollaborateurs();
    }
}
