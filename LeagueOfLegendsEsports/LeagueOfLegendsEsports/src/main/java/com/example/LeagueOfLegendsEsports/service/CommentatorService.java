package com.example.LeagueOfLegendsEsports.service;

import com.example.LeagueOfLegendsEsports.controller.resources.CommentatorResource;
import com.example.LeagueOfLegendsEsports.controller.resources.GameResource;
import com.example.LeagueOfLegendsEsports.entity.Commentator;
import com.example.LeagueOfLegendsEsports.entity.Game;

import java.util.List;

public interface CommentatorService {
    List<CommentatorResource> findAll();

    CommentatorResource save(CommentatorResource commentator);

    CommentatorResource findById(Long id);

    Commentator update(Long id, CommentatorResource commentatorResource);

    void delete(Long id);
}
