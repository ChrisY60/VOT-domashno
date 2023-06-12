package com.example.LeagueOfLegendsEsports.controller;

import com.example.LeagueOfLegendsEsports.controller.resources.CommentatorResource;
import com.example.LeagueOfLegendsEsports.service.CommentatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/commentators")
@RequiredArgsConstructor
public class CommentatorController {
    private final CommentatorService commentatorService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(commentatorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(commentatorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CommentatorResource commentatorResource) {
        CommentatorResource saved = commentatorService.save(commentatorResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/commentators/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CommentatorResource commentatorResource, @PathVariable long id) {
        return ResponseEntity.ok(commentatorService.update(id, commentatorResource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        commentatorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
