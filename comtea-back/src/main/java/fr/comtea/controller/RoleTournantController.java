package fr.comtea.controller;

import java.util.List;

import fr.comtea.service.collaborateur.Collaborateur;
import fr.comtea.service.roletournant.HistoriqueElection;
import fr.comtea.service.roletournant.RoleTournantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "role-tournant-api")
@RequestMapping("/api/role-tournant")
public class RoleTournantController {

    private final RoleTournantService roleTournantService;

    @GetMapping(path = "/{role}/historique", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HistoriqueElection> historique(@PathVariable("role") final String role) {
        return roleTournantService.recupererHistoriqueElectionPourRole(role);
    }

    @GetMapping(path = "/{role}/election", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collaborateur election(@PathVariable("role") final String role) {
        return roleTournantService.lancerElectionPourRole(role);
    }
}

