package com.example.LeagueOfLegendsEsports.controller.resources;
import lombok.Data;

import java.util.List;

@Data
public class TeamResource {
    private Long id;
    private String name;
    private List<PlayerResource> players;
    private List<GameResource> matchesAsBlueTeam;
    private List<GameResource> matchesAsRedTeam;
    private List<GameResource> matchesWon;
}