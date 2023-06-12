package com.example.LeagueOfLegendsEsports.controller;

import com.example.LeagueOfLegendsEsports.controller.resources.GameResource;
import com.example.LeagueOfLegendsEsports.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(gameService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GameResource gameResource) {
        GameResource saved = gameService.save(gameResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/games/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody GameResource gameResource, @PathVariable long id) {
        return ResponseEntity.ok(gameService.update(id, gameResource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
