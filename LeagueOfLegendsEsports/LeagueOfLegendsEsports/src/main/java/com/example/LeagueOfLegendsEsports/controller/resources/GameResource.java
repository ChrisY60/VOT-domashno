package com.example.LeagueOfLegendsEsports.controller.resources;

import com.example.LeagueOfLegendsEsports.entity.Champion;
import com.example.LeagueOfLegendsEsports.entity.Commentator;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class GameResource {
    private Long id;
    private LocalDate date;
    private String blueTeam;
    private String redTeam;
    private String winnerTeam;
    private String stadium;
    private List<CommentatorResource> commentators;
    private List<ChampionResource> blueTeamChampions;
    private List<ChampionResource> redTeamChampions;
    private List<ChampionResource> winnerTeamChampions;
}
