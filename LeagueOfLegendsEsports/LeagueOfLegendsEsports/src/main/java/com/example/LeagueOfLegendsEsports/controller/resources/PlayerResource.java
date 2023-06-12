package com.example.LeagueOfLegendsEsports.controller.resources;

import lombok.Data;

@Data
public class PlayerResource {
    private Long id;
    private String name;
    private String nickname;
    private String role;
    private String team;
}

