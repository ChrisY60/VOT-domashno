package com.example.LeagueOfLegendsEsports.service;

import com.example.LeagueOfLegendsEsports.controller.resources.PlayerResource;
import com.example.LeagueOfLegendsEsports.entity.Player;

import java.util.List;

public interface PlayerService {
    List<PlayerResource> findAll();

    PlayerResource save(PlayerResource player);

    PlayerResource findById(Long id);

    Player update(Long id, PlayerResource playerResource);

    void delete(Long id);
}
