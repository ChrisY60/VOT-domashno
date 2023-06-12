package com.example.LeagueOfLegendsEsports.controller.resources;

import lombok.Data;

import java.util.List;

@Data
public class StadiumResource {
    private Long id;
    private String name;
    private String location;
    private int capacity;
    private List<GameResource> gamesPlayed;
}