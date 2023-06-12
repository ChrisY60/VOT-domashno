package com.example.LeagueOfLegendsEsports.controller.resources;

import com.example.LeagueOfLegendsEsports.entity.Game;
import lombok.Data;

import java.util.List;

@Data
public class CommentatorResource {
    private Long id;
    private String name;
    private List<GameResource> gamesCommentated;
    private String languages;
}
