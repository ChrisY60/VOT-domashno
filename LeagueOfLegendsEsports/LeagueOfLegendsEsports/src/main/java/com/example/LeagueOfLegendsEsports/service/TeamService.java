package com.example.LeagueOfLegendsEsports.service;

import com.example.LeagueOfLegendsEsports.controller.resources.PlayerResource;
import com.example.LeagueOfLegendsEsports.controller.resources.TeamResource;
import com.example.LeagueOfLegendsEsports.entity.Player;
import com.example.LeagueOfLegendsEsports.entity.Team;

import java.util.List;

public interface TeamService {
    List<TeamResource> findAll();

    TeamResource save(TeamResource team);

    TeamResource findById(Long id);

    Team update(Long id, TeamResource teamResource);

    void delete(Long id);
}