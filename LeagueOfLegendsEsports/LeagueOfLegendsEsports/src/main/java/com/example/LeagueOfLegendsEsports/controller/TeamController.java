package com.example.LeagueOfLegendsEsports.controller;

import com.example.LeagueOfLegendsEsports.controller.resources.TeamResource;
import com.example.LeagueOfLegendsEsports.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(teamService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(teamService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TeamResource teamResource) {
        TeamResource saved = teamService.save(teamResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/teams/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TeamResource teamResource, @PathVariable long id) {
        return ResponseEntity.ok(teamService.update(id, teamResource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        teamService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
