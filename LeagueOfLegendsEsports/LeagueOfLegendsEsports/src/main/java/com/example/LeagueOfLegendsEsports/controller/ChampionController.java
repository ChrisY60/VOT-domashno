package com.example.LeagueOfLegendsEsports.controller;

import com.example.LeagueOfLegendsEsports.controller.resources.ChampionResource;
import com.example.LeagueOfLegendsEsports.service.ChampionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/champions")
@RequiredArgsConstructor
public class ChampionController {
    private final ChampionService championService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(championService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(championService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ChampionResource championResource) {
        ChampionResource saved = championService.save(championResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/champions/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ChampionResource championResource, @PathVariable long id) {
        return ResponseEntity.ok(championService.update(id, championResource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        championService.delete(id);
        return ResponseEntity.noContent().build();
    }
}