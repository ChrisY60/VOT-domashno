package com.example.LeagueOfLegendsEsports.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "blueTeam")
    private List<Game> matchesAsBlueTeam;

    @OneToMany(mappedBy = "redTeam")
    private List<Game> matchesAsRedTeam;

    @OneToMany(mappedBy = "winnerTeam")
    private List<Game> matchesWon;

    @OneToMany(mappedBy = "team")
    private List<Player> players;
}
