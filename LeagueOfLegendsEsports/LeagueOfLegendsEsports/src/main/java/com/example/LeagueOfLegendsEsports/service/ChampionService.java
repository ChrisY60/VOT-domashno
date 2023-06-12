package com.example.LeagueOfLegendsEsports.service;

import com.example.LeagueOfLegendsEsports.controller.resources.ChampionResource;
import com.example.LeagueOfLegendsEsports.controller.resources.GameResource;
import com.example.LeagueOfLegendsEsports.controller.resources.PlayerResource;
import com.example.LeagueOfLegendsEsports.entity.Champion;
import com.example.LeagueOfLegendsEsports.entity.Game;
import com.example.LeagueOfLegendsEsports.entity.Player;

import java.util.List;

public interface ChampionService {
    List<ChampionResource> findAll();

    ChampionResource save(ChampionResource champion);

    ChampionResource findById(Long id);

    Champion update(Long id, ChampionResource championResource);

    void delete(Long id);
}
