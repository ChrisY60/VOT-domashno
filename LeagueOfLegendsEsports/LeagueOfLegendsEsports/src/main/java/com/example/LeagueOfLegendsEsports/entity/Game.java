package com.example.LeagueOfLegendsEsports.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Team blueTeam;

    @ManyToOne
    private Team redTeam;

    @ManyToOne
    private Team winnerTeam;

    @ManyToOne
    private Stadium stadium;

    @ManyToMany
    @JoinTable(name = "game_blue_team_champions",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "champion_id"))
    private List<Champion> blueTeamChampions;

    @ManyToMany
    @JoinTable(name = "game_red_team_champions",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "champion_id"))
    private List<Champion> redTeamChampions;

    @ManyToMany
    @JoinTable(name = "game_winner_team_champions",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "champion_id"))
    private List<Champion> winnerTeamChampions;

    @ManyToMany
    @JoinTable(name = "game_commentators",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "commentator_id"))
    private List<Commentator> commentators;


}
