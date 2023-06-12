package com.example.LeagueOfLegendsEsports.service;

import com.example.LeagueOfLegendsEsports.controller.resources.GameResource;
import com.example.LeagueOfLegendsEsports.controller.resources.PlayerResource;
import com.example.LeagueOfLegendsEsports.entity.Game;
import com.example.LeagueOfLegendsEsports.entity.Player;

import java.util.List;

public interface GameService {
    List<GameResource> findAll();

    GameResource save(GameResource game);

    GameResource findById(Long id);

    Game update(Long id, GameResource gameResource);

    void delete(Long id);
}
