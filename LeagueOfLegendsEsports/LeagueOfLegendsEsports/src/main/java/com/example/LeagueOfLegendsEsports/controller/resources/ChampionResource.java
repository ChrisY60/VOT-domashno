package com.example.LeagueOfLegendsEsports.controller.resources;

import com.example.LeagueOfLegendsEsports.entity.Game;
import lombok.Data;

import java.util.List;

@Data
public class ChampionResource {
    private Long id;
    private String name;
    private List<GameResource> gamesAsBlueTeamChampion;
    private List<GameResource> gamesAsRedTeamChampion;
    private List<GameResource> gamesAsWinnerTeamChampion;
}
