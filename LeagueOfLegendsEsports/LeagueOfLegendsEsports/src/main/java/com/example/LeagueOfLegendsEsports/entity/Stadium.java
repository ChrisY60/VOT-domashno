package com.example.LeagueOfLegendsEsports.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Stadium {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;
    private int capacity;

    @OneToMany(mappedBy = "stadium")
    private List<Game> gamesPlayed;
}
