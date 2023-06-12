package com.example.LeagueOfLegendsEsports.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Champion {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "blueTeamChampions")
    private List<Game> gamesAsBlueTeamChampion;

    @ManyToMany(mappedBy = "redTeamChampions")
    private List<Game> gamesAsRedTeamChampion;

    @ManyToMany(mappedBy = "winnerTeamChampions")
    private List<Game> gamesAsWinnerTeamChampion;
}
