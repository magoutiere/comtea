package fr.comtea.controller;

import java.util.List;

import fr.comtea.metier.collaborateur.Collaborateur;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "collaborateur-api")
@RequestMapping("/api/collaborateur")
public interface CollaborateurController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void creer(@RequestBody Collaborateur collaborateur);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Collaborateur> liste();

    @DeleteMapping("/{identifiant}")
    void supprimer(@PathVariable String identifiant);
}
