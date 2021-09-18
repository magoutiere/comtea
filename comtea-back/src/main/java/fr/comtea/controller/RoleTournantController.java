package fr.comtea.controller;

import java.util.List;

import fr.comtea.metier.collaborateur.Collaborateur;
import fr.comtea.metier.roletournant.HistoriqueElection;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "role-tournant-api")
@RequestMapping("/api/role-tournant")
public interface RoleTournantController {

    @GetMapping(path = "/{role}/historique", produces = MediaType.APPLICATION_JSON_VALUE)
    List<HistoriqueElection> historique(@PathVariable("role") String role);

    @GetMapping(path = "/{role}/election", produces = MediaType.APPLICATION_JSON_VALUE)
    Collaborateur election(@PathVariable("role") String role);
}

